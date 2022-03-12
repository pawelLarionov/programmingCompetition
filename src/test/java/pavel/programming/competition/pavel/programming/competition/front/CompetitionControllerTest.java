package pavel.programming.competition.pavel.programming.competition.front;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pavel.programming.competition.WebTestConfiguration;
import pavel.programming.competition.front.CompetitionController;
import pavel.programming.competition.front.model.TaskModel;
import pavel.programming.competition.front.model.TestModel;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CompetitionController.class)
@Import(WebTestConfiguration.class)
public class CompetitionControllerTest {
    private final static String CONTEXT_PATH = "/competition";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTaskListTest() throws Exception {
        getTaskModels();
    }

    private List<TaskModel> getTaskModels() throws Exception {
        MvcResult result = mockMvc.perform(get(CONTEXT_PATH + "/task/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        return objectMapper.readValue(
                result.getResponse().getContentAsString(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, TaskModel.class));
    }

    @Test
    public void executeAndCheckTest_Test() throws Exception {
        List<TaskModel> taskModels = getTaskModels();
        Assertions.assertFalse(taskModels.isEmpty());

        String solutionCode = readStringFromResources("TestSolution.java");

        TestModel testModel = new TestModel(
                "SuperBoy",
                solutionCode,
                taskModels.get(0).getId());

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

    private String readStringFromResources(String path) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);
        Assertions.assertNotNull(inputStream);
        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    }

}
