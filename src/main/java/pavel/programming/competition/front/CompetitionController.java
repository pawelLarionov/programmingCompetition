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

import java.util.ArrayList;
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

    /**
     * @return List of all tasks
     */
    @GetMapping(value = TASK_LIST)
    public List<TaskModel> getTaskList() {
        List<TaskModel> taskList =  new ArrayList<>();
        taskList.add(new TaskModel("name1", "description1", "p_in1", "p_out1"));
        taskList.add(new TaskModel("name2", "description2", "p_in3", "p_out3"));
        taskList.add(new TaskModel("name3", "description3", "p_in4", "p_out4"));
        taskList.add(new TaskModel("name4", "description4", "p_in5", "p_out5"));
        return taskList;
    }

    /**
     * @param test - Test to complete the task
     * @return true - if the submitted solution output value equals expected output value
     */
    @PostMapping(value = EXECUTE_AND_CHECK)
    public Boolean executeAndCheckTest(@RequestBody TestModel test) {
        return "11".equals(test.getPlayerNickName());
    }

    /**
     *
     * @param count - max row count in top list
     * @return List of the top players, list.size <= count
     */
    @GetMapping(value = PLAYER_TOP_LIST)
    public List<SuccessScoreModel> getPlayerTopList(@PathVariable("count") Integer count) {
        List<SuccessScoreModel> successScores =  new ArrayList<>();
        successScores.add(new SuccessScoreModel("name1 " + count, 2, "name1, name2"));
        successScores.add(new SuccessScoreModel("name2 " + count, 2, "name3"));
        successScores.add(new SuccessScoreModel("name3 " + count, 2, "name4, name5"));
        return successScores;
    }

}
