package pavel.programming.competition.back.model;


/**
 *  Test to complete the task
 */
public class Test {
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
    private final Task task;

    public Test(String playerNickName, String solutionCode, Task task) {
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

    public Task getTask() {
        return task;
    }
}
