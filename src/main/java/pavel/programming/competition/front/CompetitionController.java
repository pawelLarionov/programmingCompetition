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
import pavel.programming.competition.front.service.CompetitionFrontService;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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

    private final CompetitionFrontService competitionFrontService;

    public CompetitionController(CompetitionFrontService competitionFrontService) {
        this.competitionFrontService = competitionFrontService;
    }

    /**
     * @return List of all tasks
     */
    @GetMapping(value = TASK_LIST)
    public List<TaskModel> getTaskList() {
        return competitionFrontService.getTaskList();
    }

    /**
     * @param test - Test to complete the task
     * @return true - if the submitted solution output value equals expected output value
     */
    @PostMapping(value = EXECUTE_AND_CHECK)
    public boolean executeAndCheckTest(@Valid @RequestBody TestModel test) {
        return competitionFrontService.executeAndCheckTest(test);
    }

    /**
     * @param count - max row count in top list
     * @return List of the top players, list.size <= count
     */
    @GetMapping(value = PLAYER_TOP_LIST)
    public List<SuccessScoreModel> getPlayerTopList(@NotBlank @PathVariable("count") int count) {
        return competitionFrontService.getPlayerTopList(count);
    }

}
