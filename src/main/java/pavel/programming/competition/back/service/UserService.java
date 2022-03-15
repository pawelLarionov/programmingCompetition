package pavel.programming.competition.back.service;

import pavel.programming.competition.back.model.SuccessScore;

import java.util.List;

public interface UserService {
    /**
     * Add task to user
     * user searched by playerNickName and and if it doesn't exist yet, a new one is created
     *
     * @param playerNickName player nick name
     * @param taskId         Task id
     */
    void addTaskToUser(String playerNickName, Long taskId);

    /**
     * @param count - max row count in top list
     * @return List of the top players with tasks names, list.size <= count
     */
    List<SuccessScore> getUserTopList(int count);
}
