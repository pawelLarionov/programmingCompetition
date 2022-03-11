package pavel.programming.competition.front.model;


/**
 *  Test to complete the task
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
     * Task that this test solves
     */
    private final TaskModel task;

    public TestModel(String playerNickName, String solutionCode, TaskModel task) {
        this.playerNickName = playerNickName;
        this.solutionCode = solutionCode;
        this.task = task;
    }

    public String getPlayerNickName() {
        return playerNickName;
    }

    public String getSolutionCode() {
        return solutionCode;
    }

    public TaskModel getTask() {
        return task;
    }
}
