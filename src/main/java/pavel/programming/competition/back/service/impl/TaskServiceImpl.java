package pavel.programming.competition.back.service.impl;

import org.springframework.stereotype.Service;
import pavel.programming.competition.back.dao.TaskRepository;
import pavel.programming.competition.back.dao.entity.TaskEntity;
import pavel.programming.competition.back.model.Task;
import pavel.programming.competition.back.service.TaskService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return StreamSupport.stream(taskRepository.findAll().spliterator(), false).
                map(this::map).collect(Collectors.toList());
    }

    @Override
    public Task findByGlobalId(UUID taskId) {
        TaskEntity task = taskRepository.findByGlobalId(taskId);
        return task != null ? map(task) : null;
    }

    private Task map(TaskEntity taskEntity) {
        return new Task(
                taskEntity.getId(),
                taskEntity.getGlobalId(),
                taskEntity.getName(),
                taskEntity.getDescription(),
                taskEntity.getInputParameter(),
                taskEntity.getOutputParameter());
    }
}
