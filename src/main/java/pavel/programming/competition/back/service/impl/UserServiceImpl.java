package pavel.programming.competition.back.service.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pavel.programming.competition.back.dao.TaskRepository;
import pavel.programming.competition.back.dao.UserRepository;
import pavel.programming.competition.back.dao.entity.TaskEntity;
import pavel.programming.competition.back.dao.entity.UserEntity;
import pavel.programming.competition.back.model.SuccessScore;
import pavel.programming.competition.back.service.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public UserServiceImpl(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional
    public void addTaskToUser(String playerNickName, Long taskId) {
        UserEntity userEntity = userRepository.findByNickName(playerNickName);
        if (userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setNickName(playerNickName);
        }
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow(IllegalArgumentException::new);
        userEntity.getSuccessTasks().add(taskEntity);
        userRepository.save(userEntity);
    }

    @Override
    public List<SuccessScore> getUserTopList(int count) {
        Pageable topPage = PageRequest.of(0, count);
        List<UserEntity> topUserList = userRepository.queryUserOrderedBySuccessTasksCount(topPage);

        return topUserList.stream().map(user ->
                new SuccessScore(
                        user.getNickName(),
                        user.getSuccessTasks().size(),
                        user.getSuccessTasks().stream().map(TaskEntity::getName).collect(Collectors.joining(","))
                )).collect(Collectors.toList());
    }

}
