package pavel.programming.competition.back.service;

import java.util.UUID;

public interface TestService {
    /**
     * Execute test, check result and store to database if result success
     *
     * @param playerNickName Player nick name, who wrote the test
     * @param solutionCode   Program solution code to solve the problem
     * @param taskId         Task id that this test solves
     * @return true - if the submitted solution output value equals expected output value
     */
    boolean executeAndCheckTest(String playerNickName, String solutionCode, UUID taskId);
}
