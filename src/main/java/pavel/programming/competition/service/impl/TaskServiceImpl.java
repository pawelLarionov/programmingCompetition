package pavel.programming.competition.service.impl;

import org.springframework.stereotype.Service;
import pavel.programming.competition.front.model.TaskModel;
import pavel.programming.competition.service.TaskService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public List<TaskModel> getTaskList() {
        List<TaskModel> taskList =  new ArrayList<>();
        taskList.add(new TaskModel("name1", "description1", "p_in1", "p_out1"));
        taskList.add(new TaskModel("name2", "description2", "p_in3", "p_out3"));
        taskList.add(new TaskModel("name3", "description3", "p_in4", "p_out4"));
        taskList.add(new TaskModel("name4", "description4", "p_in5", "p_out5"));
        return taskList;
    }
}
