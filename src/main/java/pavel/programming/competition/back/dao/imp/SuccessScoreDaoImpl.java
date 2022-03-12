package pavel.programming.competition.back.dao.imp;

import org.springframework.stereotype.Service;
import pavel.programming.competition.back.dao.SuccessScoreDao;
import pavel.programming.competition.back.model.SuccessScore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuccessScoreDaoImpl implements SuccessScoreDao {
    private static final List<SuccessScore> successScores = new ArrayList<>();

    static {
        successScores.add(new SuccessScore("name1 ", 2, "name1, name2"));
        successScores.add(new SuccessScore("name2 ", 2, "name3"));
        successScores.add(new SuccessScore("name3 ", 2, "name4, name5"));
        successScores.add(new SuccessScore("name4 ", 2, "name1, name12"));
        successScores.add(new SuccessScore("name5 ", 2, "name11, name5"));
    }

    @Override
    public List<SuccessScore> getPlayerTopList(int count) {
        return successScores.stream().limit(count).collect(Collectors.toList());
    }
}
