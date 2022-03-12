package pavel.programming.competition.back.model;

/**
 *  Task to solve
 */
public class Task {
    /**
     *  Task name
     */
    private final String name;

    /**
     *  Task description
     */
    private final String description;

    /**
     *  Test input parameter with which the solution code will be submitted (compiled and run)
     */
    private final String inputParameter;

    /**
     * Test output parameter with which the submission output will be compared to determine success/failure
     */
    private final String outputParameter;

    public Task(String name, String description, String inputParameter, String outputParameter) {
        this.name = name;
        this.description = description;
        this.inputParameter = inputParameter;
        this.outputParameter = outputParameter;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getInputParameter() {
        return inputParameter;
    }

    public String getOutputParameter() {
        return outputParameter;
    }
}
