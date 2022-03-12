package pavel.programming.competition.back.service.impl;

import org.springframework.stereotype.Service;
import pavel.programming.competition.back.service.JdoodleService;

@Service
public class JdoodleServiceImpl implements JdoodleService {
    @Override
    public String execute(String solutionCode, String[] parameters) {
        return "1";
    }
}
