package pavel.programming.competition.front.service.impl;

import org.springframework.stereotype.Service;
import pavel.programming.competition.back.service.SuccessScoreService;
import pavel.programming.competition.back.service.TaskService;
import pavel.programming.competition.back.service.TestService;
import pavel.programming.competition.front.model.SuccessScoreModel;
import pavel.programming.competition.front.model.TaskModel;
import pavel.programming.competition.front.model.TestModel;
import pavel.programming.competition.front.service.CompetitionFrontService;
import pavel.programming.competition.front.service.ModelMapper;

import java.util.List;

@Service
public class CompetitionFrontServiceImpl implements CompetitionFrontService {

    private final SuccessScoreService successScoreService;
    private final TaskService taskService;
    private final TestService testService;
    private final ModelMapper modelMapper;

    public CompetitionFrontServiceImpl(SuccessScoreService successScoreService,
                                       TaskService taskService, TestService testService, ModelMapper modelMapper) {
        this.successScoreService = successScoreService;
        this.taskService = taskService;
        this.testService = testService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TaskModel> getTaskList() {
        return modelMapper.mapTaskToFront(taskService.getTaskList());
    }

    @Override
    public List<SuccessScoreModel> getPlayerTopList(int count) {
        return modelMapper.mapSuccessScoreToFront(successScoreService.getPlayerTopList(count));
    }

    @Override
    public boolean executeAndCheckTest(TestModel test) {
        return testService.executeAndCheckTest(test.getPlayerNickName(), test.getSolutionCode(), test.getTaskId());
    }

}