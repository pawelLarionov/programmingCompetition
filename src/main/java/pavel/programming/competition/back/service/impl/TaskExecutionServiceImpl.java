package pavel.programming.competition.back.service.impl;

import org.springframework.stereotype.Service;
import pavel.programming.competition.back.model.Task;
import pavel.programming.competition.back.model.Test;
import pavel.programming.competition.back.remotecall.jdoodle.JDoodleService;
import pavel.programming.competition.back.service.TaskExecutionService;
import pavel.programming.competition.back.service.TaskService;
import pavel.programming.competition.back.service.TestService;

import java.util.UUID;

@Service
public class TaskExecutionServiceImpl implements TaskExecutionService {

    private final JDoodleService jdoodleService;
    private final TaskService taskService;
    private final TestService testService;

    public TaskExecutionServiceImpl(JDoodleService jdoodleService, TaskService taskService, TestService testService) {
        this.jdoodleService = jdoodleService;
        this.taskService = taskService;
        this.testService = testService;
    }

    @Override
    public boolean executeAndCheckTest(String playerNickName, String solutionCode, UUID taskId) {
        Task task = taskService.getTaskById(taskId);

        if (task == null) {
            throw new IllegalArgumentException("not found task by id " + taskId);
        }

        String result = jdoodleService.executeJava(solutionCode, task.getInputParameter());
        boolean success = result != null && result.trim().equals(task.getOutputParameter());
        if (success) {
            Test test = new Test(playerNickName, solutionCode, task);
            testService.saveTest(test);
        }
        return success;
    }
}