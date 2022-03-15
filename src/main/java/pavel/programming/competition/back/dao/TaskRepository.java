package pavel.programming.competition.back.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pavel.programming.competition.back.dao.entity.TaskEntity;

import java.util.UUID;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
    TaskEntity findByGlobalId(UUID globalId);
}
