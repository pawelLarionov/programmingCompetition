package pavel.programming.competition.back.service.impl;

import org.springframework.stereotype.Service;
import pavel.programming.competition.back.model.Task;
import pavel.programming.competition.back.remotecall.jdoodle.JDoodleService;
import pavel.programming.competition.back.service.TaskExecutionService;
import pavel.programming.competition.back.service.TaskService;
import pavel.programming.competition.back.service.UserService;

import java.util.UUID;

@Service
public class TaskExecutionServiceImpl implements TaskExecutionService {

    private final JDoodleService jdoodleService;
    private final TaskService taskService;
    private final UserService testService;

    public TaskExecutionServiceImpl(JDoodleService jdoodleService, TaskService taskService, UserService testService) {
        this.jdoodleService = jdoodleService;
        this.taskService = taskService;
        this.testService = testService;
    }

    @Override
    public boolean executeAndCheckTest(String playerNickName, String solutionCode, UUID taskGlobalId) {
        Task task = taskService.findByGlobalId(taskGlobalId);
        if (task == null) {
            throw new IllegalArgumentException("unknown task with taskGlobalId: " + taskGlobalId);
        }

        String result = "2";//jdoodleService.executeJava(solutionCode, task.getInputParameter());
        boolean success = result != null && result.trim().equals(task.getOutputParameter());
        if (success) {
            testService.addTaskToUser(playerNickName, task.getId());
        }
        return success;
    }
}
