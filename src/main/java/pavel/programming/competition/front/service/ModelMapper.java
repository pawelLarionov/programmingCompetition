package pavel.programming.competition.front.service;

import pavel.programming.competition.back.model.SuccessScore;
import pavel.programming.competition.back.model.Task;
import pavel.programming.competition.front.model.SuccessScoreModel;
import pavel.programming.competition.front.model.TaskModel;

import java.util.List;

public interface ModelMapper {
    List<TaskModel> mapTaskToFront(List<Task> tasks);

    List<SuccessScoreModel> mapSuccessScoreToFront(List<SuccessScore> successScores);
}
