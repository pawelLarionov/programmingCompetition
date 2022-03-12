package pavel.programming.competition.front.model;


import java.util.UUID;

/**
 * Test to complete the task
 */
public class TestModel {
    /**
     *  Player nick name, who wrote the test
     */
    private final String playerNickName;

    /**
     * Program solution code to solve the problem
     */
    private final String solutionCode;

    /**
     * Task id that this test solves
     */
    private final UUID taskId;

    public TestModel(String playerNickName, String solutionCode, UUID taskId) {
        this.playerNickName = playerNickName;
        this.solutionCode = solutionCode;
        this.taskId = taskId;
    }

    public String getPlayerNickName() {
        return playerNickName;
    }

    public String getSolutionCode() {
        return solutionCode;
    }

    public UUID getTaskId() {
        return taskId;
    }
}
