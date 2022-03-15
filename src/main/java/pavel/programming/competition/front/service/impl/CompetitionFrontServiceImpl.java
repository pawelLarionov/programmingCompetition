package pavel.programming.competition.front.service.impl;

import org.springframework.stereotype.Service;
import pavel.programming.competition.back.service.TaskExecutionService;
import pavel.programming.competition.back.service.TaskService;
import pavel.programming.competition.back.service.UserService;
import pavel.programming.competition.front.model.SuccessScoreModel;
import pavel.programming.competition.front.model.TaskModel;
import pavel.programming.competition.front.model.TestModel;
import pavel.programming.competition.front.service.CompetitionFrontService;
import pavel.programming.competition.front.service.ModelMapper;

import java.util.List;

@Service
public class CompetitionFrontServiceImpl implements CompetitionFrontService {

    private final UserService userService;
    private final TaskService taskService;
    private final TaskExecutionService taskExecutionService;
    private final ModelMapper modelMapper;

    public CompetitionFrontServiceImpl(UserService userService, TaskService taskService, TaskExecutionService taskExecutionService, ModelMapper modelMapper) {
        this.userService = userService;
        this.taskService = taskService;
        this.taskExecutionService = taskExecutionService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TaskModel> getTaskList() {
        return modelMapper.mapTaskToFront(taskService.findAll());
    }

    @Override
    public List<SuccessScoreModel> getPlayerTopList(int count) {
        return modelMapper.mapSuccessScoreToFront(userService.getUserTopList(count));
    }

    @Override
    public boolean executeAndCheckTest(TestModel test) {
        return taskExecutionService.executeAndCheckTest(test.getPlayerNickName(), test.getSolutionCode(), test.getTaskGlobalId());
    }

}
