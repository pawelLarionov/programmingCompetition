package pavel.programming.competition.service.impl;

import org.springframework.stereotype.Service;
import pavel.programming.competition.front.model.SuccessScoreModel;
import pavel.programming.competition.service.SuccessScoreService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuccessScoreServiceImpl implements SuccessScoreService {

    @Override
    public List<SuccessScoreModel> getPlayerTopList(int count) {
        List<SuccessScoreModel> successScores =  new ArrayList<>();
        successScores.add(new SuccessScoreModel("name1 " + count, 2, "name1, name2"));
        successScores.add(new SuccessScoreModel("name2 " + count, 2, "name3"));
        successScores.add(new SuccessScoreModel("name3 " + count, 2, "name4, name5"));
        return successScores;
    }
}
