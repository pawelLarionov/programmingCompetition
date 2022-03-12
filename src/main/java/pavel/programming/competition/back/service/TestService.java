package pavel.programming.competition.back.service;

import pavel.programming.competition.front.model.TestModel;

public interface TestService {
    /**
     * @param test - Test to complete the task
     * @return true - if the submitted solution output value equals expected output value
     */
    boolean executeAndCheckTest(TestModel test);
}
