package pavel.programming.competition.front.service.impl;

import org.springframework.stereotype.Service;
import pavel.programming.competition.back.model.SuccessScore;
import pavel.programming.competition.back.model.Task;
import pavel.programming.competition.front.model.SuccessScoreModel;
import pavel.programming.competition.front.model.TaskModel;
import pavel.programming.competition.front.service.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelMapperImpl implements ModelMapper {
    private TaskModel mapTaskToFront(Task task) {
        return new TaskModel(task.getId(), task.getName(), task.getDescription());
    }

    @Override
    public List<TaskModel> mapTaskToFront(List<Task> tasks) {
        return tasks.isEmpty() ? null :
                tasks.stream().map(this::mapTaskToFront).collect(Collectors.toList());
    }

    private SuccessScoreModel mapSuccessScoreToFront(SuccessScore successScore) {
        return new SuccessScoreModel(
                successScore.getPlayerNickName(),
                successScore.getCountSuccessfulTests(),
                successScore.getNamesOfSolvedTasks());
    }

    @Override
    public List<SuccessScoreModel> mapSuccessScoreToFront(List<SuccessScore> successScores) {
        return successScores.isEmpty() ? null :
                successScores.stream().map(this::mapSuccessScoreToFront).collect(Collectors.toList());
    }
}
