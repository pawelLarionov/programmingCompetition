package pavel.programming.competition.back.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "Task")
public class TaskEntity extends IdEntity {
    @Id
    @SequenceGenerator(name = "TaskIDSequence", sequenceName = "TASK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TaskIDSequence")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private UUID globalId;
    private String name;
    private String description;
    private String inputParameter;
    private String outputParameter;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInputParameter() {
        return inputParameter;
    }

    public void setInputParameter(String inputParameter) {
        this.inputParameter = inputParameter;
    }

    public String getOutputParameter() {
        return outputParameter;
    }

    public void setOutputParameter(String outputParameter) {
        this.outputParameter = outputParameter;
    }

    public UUID getGlobalId() {
        return globalId;
    }

    public void setGlobalId(UUID globalId) {
        this.globalId = globalId;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "globalId=" + globalId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", inputParameter='" + inputParameter + '\'' +
                ", outputParameter='" + outputParameter + '\'' +
                '}';
    }
}
