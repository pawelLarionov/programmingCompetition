package pavel.programming.competition.back.dao;

import pavel.programming.competition.back.model.SuccessScore;

import java.util.List;

public interface SuccessScoreDao {
    List<SuccessScore> getPlayerTopList(int count);
}
