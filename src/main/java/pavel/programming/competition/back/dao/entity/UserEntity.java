package pavel.programming.competition.back.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
public class UserEntity extends IdEntity {
    @Id
    @SequenceGenerator(name = "UserIDSequence", sequenceName = "USER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserIDSequence")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Player nick name
     */
    private String nickName;


    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_task",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "task_id")}
    )
    private Set<TaskEntity> successTasks = new HashSet<>();

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Set<TaskEntity> getSuccessTasks() {
        return successTasks;
    }

    public void setSuccessTasks(Set<TaskEntity> successTasks) {
        this.successTasks = successTasks;
    }
}
