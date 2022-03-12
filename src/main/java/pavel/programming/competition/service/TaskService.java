package pavel.programming.competition.service;

import pavel.programming.competition.front.model.TaskModel;

import java.util.List;

public interface TaskService {
    /**
     * @return List of all tasks
     */
    List<TaskModel> getTaskList();
}
