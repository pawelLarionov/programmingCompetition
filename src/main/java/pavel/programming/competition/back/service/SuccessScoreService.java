package pavel.programming.competition.back.service;

import pavel.programming.competition.back.model.SuccessScore;

import java.util.List;

public interface SuccessScoreService {

    /**
     * @param count - max row count in top list
     * @return List of the top players, list.size <= count
     */
    List<SuccessScore> getPlayerTopList(int count);
}