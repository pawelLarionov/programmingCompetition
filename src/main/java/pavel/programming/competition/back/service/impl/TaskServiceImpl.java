package pavel.programming.competition.back.service.impl;

import org.springframework.stereotype.Service;
import pavel.programming.competition.back.dao.TaskDao;
import pavel.programming.competition.back.model.Task;
import pavel.programming.competition.back.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDAO;

    public TaskServiceImpl(TaskDao taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public List<Task> getTaskList() {
        return taskDAO.getTaskList();
    }
}
