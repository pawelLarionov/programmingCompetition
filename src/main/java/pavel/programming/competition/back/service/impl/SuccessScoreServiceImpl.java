package pavel.programming.competition.back.service.impl;

import org.springframework.stereotype.Service;
import pavel.programming.competition.back.dao.SuccessScoreDao;
import pavel.programming.competition.back.model.SuccessScore;
import pavel.programming.competition.back.service.SuccessScoreService;

import java.util.List;

@Service
public class SuccessScoreServiceImpl implements SuccessScoreService {

    private final SuccessScoreDao successScoreDao;

    public SuccessScoreServiceImpl(SuccessScoreDao successScoreDao) {
        this.successScoreDao = successScoreDao;
    }

    @Override
    public List<SuccessScore> getPlayerTopList(int count) {
        return successScoreDao.getPlayerTopList(count);
    }
}
