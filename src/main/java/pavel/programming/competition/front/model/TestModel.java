package pavel.programming.competition.front.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Test to complete the task
 */
public class TestModel {
    /**
     *  Player nick name, who wrote the test
     */
    @NotBlank(message = "playerNickName is mandatory")
    private final String playerNickName;

    /**
     * Program solution code to solve the problem
     */
    @NotBlank(message = "solutionCode is mandatory")
    private final String solutionCode;

    /**
     * Task id that this test solves
     */
    @NotNull(message = "taskGlobalId is mandatory")
    private final UUID taskGlobalId;

    public TestModel(String playerNickName, String solutionCode, UUID taskGlobalId) {
        this.playerNickName = playerNickName;
        this.solutionCode = solutionCode;
        this.taskGlobalId = taskGlobalId;
    }

    public String getPlayerNickName() {
        return playerNickName;
    }

    public String getSolutionCode() {
        return solutionCode;
    }

    public UUID getTaskGlobalId() {
        return taskGlobalId;
    }
}
