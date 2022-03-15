package pavel.programming.competition.back.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pavel.programming.competition.back.dao.entity.UserEntity;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query("select u from UserEntity u order by size(u.successTasks) desc")
    List<UserEntity> queryUserOrderedBySuccessTasksCount(Pageable pageable);


    UserEntity findByNickName(String nickName);
}
