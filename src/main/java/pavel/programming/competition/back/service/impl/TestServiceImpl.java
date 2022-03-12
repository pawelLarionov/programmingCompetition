package pavel.programming.competition.back.service.impl;

import org.springframework.stereotype.Service;
import pavel.programming.competition.back.dao.TaskDao;
import pavel.programming.competition.back.model.Task;
import pavel.programming.competition.back.remotecall.jdoodle.JDoodleService;
import pavel.programming.competition.back.service.TestService;

import java.util.UUID;

@Service
public class TestServiceImpl implements TestService {

    private final JDoodleService jdoodleService;

    private final TaskDao taskDAO;

    public TestServiceImpl(JDoodleService jdoodleService, TaskDao taskDAO) {
        this.jdoodleService = jdoodleService;
        this.taskDAO = taskDAO;
    }

    @Override
    public boolean executeAndCheckTest(String playerNickName, String solutionCode, UUID taskId) {
        Task task = taskDAO.getTaskById(taskId);

        if (task == null) {
            throw new IllegalArgumentException("Not found task by id " + taskId);
        }

        String result = jdoodleService.executeJava(solutionCode, task.getInputParameter());
        boolean success = result != null && result.trim().equals(task.getOutputParameter());
        //if (success) {
        // testDAO.save(test);
        //  }
        return true;
    }
}
