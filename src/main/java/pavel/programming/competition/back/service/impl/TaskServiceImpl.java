package pavel.programming.competition.back.service.impl;

import org.springframework.stereotype.Service;
import pavel.programming.competition.front.model.TaskModel;
import pavel.programming.competition.back.service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public List<TaskModel> getTaskList() {
        List<TaskModel> taskList =  new ArrayList<>();
        taskList.add(new TaskModel( UUID.randomUUID(), "name1", "description1"));
        taskList.add(new TaskModel( UUID.randomUUID(), "name2", "description2"));
        taskList.add(new TaskModel( UUID.randomUUID(), "name3", "description3"));
        taskList.add(new TaskModel( UUID.randomUUID(), "name4", "description4"));
        taskList.add(new TaskModel( UUID.randomUUID(), "name5", "description5"));
        return taskList;
    }
}
