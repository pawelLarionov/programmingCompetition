package pavel.programming.competition.back.service;

import pavel.programming.competition.back.model.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    /**
     * @return List of all tasks
     */
    List<Task> findAll();

    /**
     * Return task by id
     *
     * @param taskGlobalId - global task id
     * @return Task or null if it doesn't exist task with that taskId
     */
    Task findByGlobalId(UUID taskGlobalId);
}
