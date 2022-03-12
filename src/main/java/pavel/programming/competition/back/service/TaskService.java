package pavel.programming.competition.back.service;

import pavel.programming.competition.back.model.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    /**
     * @return List of all tasks
     */
    List<Task> getTaskList();

    /**
     * Return task by id
     *
     * @param taskId - task id
     * @return Task or null if it doesn't exist task with that taskId
     */
    Task getTaskById(UUID taskId);
}
