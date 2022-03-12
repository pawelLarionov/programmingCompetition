package pavel.programming.competition.back.service;

import pavel.programming.competition.back.model.Task;

import java.util.List;

public interface TaskService {
    /**
     * @return List of all tasks
     */
    List<Task> getTaskList();
}
