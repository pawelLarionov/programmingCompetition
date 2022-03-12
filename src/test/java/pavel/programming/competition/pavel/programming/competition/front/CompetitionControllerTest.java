package pavel.programming.competition.pavel.programming.competition.front;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pavel.programming.competition.front.CompetitionController;
import pavel.programming.competition.front.model.SuccessScoreModel;
import pavel.programming.competition.front.model.TaskModel;
import pavel.programming.competition.front.model.TestModel;
import pavel.programming.competition.front.service.CompetitionFrontService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CompetitionController.class)
public class CompetitionControllerTest {
    private final static String CONTEXT_PATH = "/competition";

    @MockBean
    private CompetitionFrontService competitionFrontService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTaskListTest() throws Exception {
        List<TaskModel> taskModels = new ArrayList<>();
        taskModels.add(new TaskModel(UUID.randomUUID(), "name1", "description1"));
        taskModels.add(new TaskModel(UUID.randomUUID(), "name2", "description2"));
        taskModels.add(new TaskModel(UUID.randomUUID(), "name3", "description3"));
        Mockito.when(competitionFrontService.getTaskList()).thenReturn(taskModels);

        mockMvc.perform(get(CONTEXT_PATH + "/task/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void executeAndCheckTest_Test() throws Exception {
        Mockito.when(competitionFrontService.executeAndCheckTest(Mockito.any())).thenReturn(Boolean.TRUE);

        TestModel testModel = new TestModel(
                "SuperBoy",
                "solutionCode",
                UUID.randomUUID());

        mockMvc.perform(
                post(CONTEXT_PATH + "/test/execute-and-check")
                        .content(objectMapper.writeValueAsString(testModel))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getPlayerTopListTest() throws Exception {
        List<SuccessScoreModel> successScores = new ArrayList<>();
        successScores.add(new SuccessScoreModel("name1 ", 2, "name1, name2"));
        successScores.add(new SuccessScoreModel("name2 ", 2, "name3"));
        successScores.add(new SuccessScoreModel("name3 ", 2, "name4, name5"));
        Mockito.when(competitionFrontService.getPlayerTopList(Mockito.anyInt())).thenReturn(successScores);

        int count = 3;
        mockMvc.perform(get(CONTEXT_PATH + "/player/top-list/{count}", count))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(count)))
                .andReturn();
    }
}
