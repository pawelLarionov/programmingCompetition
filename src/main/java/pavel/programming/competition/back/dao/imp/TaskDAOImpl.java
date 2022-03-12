package pavel.programming.competition.back.dao.imp;

import org.springframework.stereotype.Service;
import pavel.programming.competition.back.dao.TaskDao;
import pavel.programming.competition.back.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskDAOImpl implements TaskDao {
    private static final List<Task> tasks = new ArrayList<>();

    static {
        tasks.add(new Task(UUID.randomUUID(), "name1", "description1", "1", "1"));
        tasks.add(new Task(UUID.randomUUID(), "name2", "description2", "2", "2"));
        tasks.add(new Task(UUID.randomUUID(), "name3", "description3", "3", "3"));
        tasks.add(new Task(UUID.randomUUID(), "name4", "description4", "4", "4"));
    }

    @Override
    public List<Task> getTaskList() {
        return tasks;
    }

    @Override
    public Task getTaskById(UUID taskId) {
        return tasks.stream().filter(task -> task.getId().equals(taskId)).findFirst().orElse(null);
    }
}
