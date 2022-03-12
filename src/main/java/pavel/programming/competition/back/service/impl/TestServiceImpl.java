package pavel.programming.competition.back.service.impl;

import org.springframework.stereotype.Service;
import pavel.programming.competition.back.dao.TaskDao;
import pavel.programming.competition.back.model.Task;
import pavel.programming.competition.back.service.JdoodleService;
import pavel.programming.competition.back.service.TestService;

import java.util.UUID;

@Service
public class TestServiceImpl implements TestService {

    private final JdoodleService jdoodleService;

    private final TaskDao taskDAO;

    public TestServiceImpl(JdoodleService jdoodleService, TaskDao taskDAO) {
        this.jdoodleService = jdoodleService;
        this.taskDAO = taskDAO;
    }

    @Override
    public boolean executeAndCheckTest(String playerNickName, String solutionCode, UUID taskId) {
        Task task = taskDAO.getTaskById(taskId);

        if (task == null) {
            throw new IllegalArgumentException("Not found task by id " + taskId);
        }

        String result = jdoodleService.execute(solutionCode, new String[]{task.getInputParameter()});

        //boolean success = task.getOutputParameter().equals(result);
        //if (success) {
        // testDAO.save(test);
        //  }
        return true;
    }
}
