package pavel.programming.competition.back.service.impl;

import org.springframework.stereotype.Service;
import pavel.programming.competition.front.model.TestModel;
import pavel.programming.competition.back.service.TestService;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public boolean executeAndCheckTest(TestModel test) {
        return "11".equals(test.getPlayerNickName());
    }
}
