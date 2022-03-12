package pavel.programming.competition.front.service;

import pavel.programming.competition.front.model.SuccessScoreModel;
import pavel.programming.competition.front.model.TaskModel;
import pavel.programming.competition.front.model.TestModel;

import java.util.List;

public interface CompetitionFrontService {
    /**
     * @return List of all tasks
     */
    List<TaskModel> getTaskList();

    /**
     * @param count - max row count in top list
     * @return List of the top players, list.size <= count
     */
    List<SuccessScoreModel> getPlayerTopList(int count);

    /**
     * @param test - Test to complete the task
     * @return true - if the submitted solution output value equals expected output value
     */
    boolean executeAndCheckTest(TestModel test);

}
