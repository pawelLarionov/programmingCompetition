package pavel.programming.competition.front.model;

import java.util.UUID;

/**
 * Task to solve
 */
public class TaskModel extends GlobalIdModel {
    /**
     *  Task name
     */
    private final String name;

    /**
     *  Task description
     */
    private final String description;

    public TaskModel(UUID id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
