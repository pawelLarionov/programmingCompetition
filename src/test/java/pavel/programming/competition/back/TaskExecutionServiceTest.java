package pavel.programming.competition.back;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pavel.programming.competition.back.model.Task;
import pavel.programming.competition.back.remotecall.jdoodle.JDoodleService;
import pavel.programming.competition.back.service.TaskExecutionService;
import pavel.programming.competition.back.service.TaskService;
import pavel.programming.competition.back.service.UserService;
import pavel.programming.competition.back.service.impl.TaskExecutionServiceImpl;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TaskExecutionServiceTest {

    private TaskExecutionService service;

    @MockBean
    private JDoodleService jDoodleService;

    @MockBean
    private TaskService taskService;

    @MockBean
    private UserService userService;

    @BeforeEach
    private void init() {
        service = new TaskExecutionServiceImpl(jDoodleService, taskService, userService);
    }

    /**
     * Check that if the user has successfully solved the problem, then he makes a record about it in the database
     */
    @Test
    public void testUserSuccessSolvedTask() {
        String jDoodleServiceExecuteResult = "result";
        when(jDoodleService.executeJava(anyString(), anyString())).thenReturn(jDoodleServiceExecuteResult);

        Long taskId = 1L;
        UUID taskGlobalId = UUID.randomUUID();
        String nickName = "SuperMan";

        Task task = new Task(taskId, taskGlobalId, "Task1", "Description1",
                "1", jDoodleServiceExecuteResult);
        when(taskService.findByGlobalId(taskGlobalId)).thenReturn(task);

        boolean result = service.executeAndCheckTest("SuperMan", "1=1", taskGlobalId);

        assertTrue(result);
        verify(userService, times(1)).addTaskToUser(nickName, taskId);
        verifyNoMoreInteractions(userService);
    }


    /**
     * Check that if the user has not solved the problem, then we do not record this in the database
     */
    @Test
    public void testUserNotSolvedTask() {
        String jDoodleServiceExecuteResult = "wrong result";
        when(jDoodleService.executeJava(anyString(), anyString())).thenReturn(jDoodleServiceExecuteResult);

        Long taskId = 1L;
        UUID taskGlobalId = UUID.randomUUID();
        String nickName = "SuperMan";

        Task task = new Task(taskId, taskGlobalId, "Task1", "Description1",
                "1", "result");
        when(taskService.findByGlobalId(taskGlobalId)).thenReturn(task);

        boolean result = service.executeAndCheckTest("SuperMan", "1=1", taskGlobalId);

        assertFalse(result);
        verifyNoInteractions(userService);
    }
}
