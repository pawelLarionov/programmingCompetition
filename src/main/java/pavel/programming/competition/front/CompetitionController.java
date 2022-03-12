package pavel.programming.competition.front;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pavel.programming.competition.front.model.SuccessScoreModel;
import pavel.programming.competition.front.model.TaskModel;
import pavel.programming.competition.front.model.TestModel;
import pavel.programming.competition.back.service.SuccessScoreService;
import pavel.programming.competition.back.service.TaskService;
import pavel.programming.competition.back.service.TestService;

import java.util.List;

/**
 * Rest controller for programming competition
 */
@RestController
@RequestMapping("/competition")
public class CompetitionController {
    private static final String TASK_LIST = "/task/list";
    private static final String EXECUTE_AND_CHECK = "/test/execute-and-check";
    private static final String PLAYER_TOP_LIST = "/player/top-list/{count}";

    private final TaskService taskService;
    private final SuccessScoreService successScoreService;
    private final TestService testService;

    public CompetitionController(TaskService taskService, SuccessScoreService successScoreService, TestService testService) {
        this.taskService = taskService;
        this.successScoreService = successScoreService;
        this.testService = testService;
    }

    /**
     * @return List of all tasks
     */
    @GetMapping(value = TASK_LIST)
    public List<TaskModel> getTaskList() {
       return taskService.getTaskList();
    }

    /**
     * @param test - Test to complete the task
     * @return true - if the submitted solution output value equals expected output value
     */
    @PostMapping(value = EXECUTE_AND_CHECK)
    public boolean executeAndCheckTest(@RequestBody TestModel test) {
        return testService.executeAndCheckTest(test);
    }

    /**
     *
     * @param count - max row count in top list
     * @return List of the top players, list.size <= count
     */
    @GetMapping(value = PLAYER_TOP_LIST)
    public List<SuccessScoreModel> getPlayerTopList(@PathVariable("count") int count) {
       return successScoreService.getPlayerTopList(count);
    }

}
