package pavel.programming.competition.back.model;

/**
 * Number of tests successfully passed by the player
 */
public class SuccessScore {
    /**
     *  Player nick name
     */
    private final String playerNickName;

    /**
     * Count of successful tests
     */
    private final long countSuccessfulTests;

    /**
     * Names of solved tasks separated by ','
     */
    private final String namesOfSolvedTasks;

    public SuccessScore(String playerNickName, long countSuccessfulTests, String namesOfSolvedTasks) {
        this.playerNickName = playerNickName;
        this.countSuccessfulTests = countSuccessfulTests;
        this.namesOfSolvedTasks = namesOfSolvedTasks;
    }

    public String getPlayerNickName() {
        return playerNickName;
    }

    public long getCountSuccessfulTests() {
        return countSuccessfulTests;
    }

    public String getNamesOfSolvedTasks() {
        return namesOfSolvedTasks;
    }
}
