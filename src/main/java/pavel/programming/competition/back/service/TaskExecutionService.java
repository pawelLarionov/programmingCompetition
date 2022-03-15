package pavel.programming.competition.back.service;

import java.util.UUID;

public interface TaskExecutionService {

    /**
     * Execute test, check result and store to database if result success
     *
     * @param playerNickName Player nick name, who wrote the test
     * @param solutionCode   Program solution code to solve the problem
     * @param taskGlobalId   Task global id that this test solves
     * @return true - if the submitted solution output value equals expected output value
     */
    boolean executeAndCheckTest(String playerNickName, String solutionCode, UUID taskGlobalId);
}
