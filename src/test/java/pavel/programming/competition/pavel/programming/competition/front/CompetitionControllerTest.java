package pavel.programming.competition.pavel.programming.competition.front;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pavel.programming.competition.front.CompetitionController;
import pavel.programming.competition.front.model.TaskModel;
import pavel.programming.competition.front.model.TestModel;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CompetitionController.class)
public class CompetitionControllerTest {
    private final static String CONTEXT_PATH = "/competition";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTaskListTest() throws Exception {
        mockMvc.perform(get(CONTEXT_PATH + "/task/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void executeAndCheckTest_Test() throws Exception {
        TaskModel taskModel = new TaskModel("Task1", "Description1", "1", "1");
        TestModel testModel  = new TestModel("SuperBoy", "System.out.println('1')",  taskModel);

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
        int count = 3;
        mockMvc.perform(get(CONTEXT_PATH + "/player/top-list/{count}", count))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(count)))
                .andReturn();
    }


}
