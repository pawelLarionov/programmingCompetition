package pavel.programming.competition.service;

import pavel.programming.competition.front.model.SuccessScoreModel;

import java.util.List;

public interface SuccessScoreService {

    /**
     *
     * @param count - max row count in top list
     * @return List of the top players, list.size <= count
     */
    List<SuccessScoreModel> getPlayerTopList(int count);
}
