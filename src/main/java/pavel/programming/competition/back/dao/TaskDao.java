package pavel.programming.competition.back.dao;


import pavel.programming.competition.back.model.Task;

import java.util.List;
import java.util.UUID;

public interface TaskDao {

    List<Task> getTaskList();

    Task getTaskById(UUID taskId);
}
