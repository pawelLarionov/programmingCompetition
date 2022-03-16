package pavel.programming.competition.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pavel.programming.competition.WebTestConfiguration;
import pavel.programming.competition.back.dao.TaskRepository;
import pavel.programming.competition.back.dao.UserRepository;
import pavel.programming.competition.back.dao.entity.TaskEntity;
import pavel.programming.competition.back.dao.entity.UserEntity;
import pavel.programming.competition.front.CompetitionController;
import pavel.programming.competition.front.model.TaskModel;
import pavel.programming.competition.front.model.TestModel;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CompetitionController.class)
@Import(WebTestConfiguration.class)
public class JDoodleIntegrationTest {
    private final static String CONTEXT_PATH = "/competition";

    private final static UUID TASK_GLOBAL_ID = UUID.randomUUID();
    private final static Long TASK_ID = 1L;

    @MockBean
    private TaskRepository taskRepository;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkJDoodleIntegrationTest() throws Exception {
        List<TaskEntity> taskEntities = new ArrayList<>();
        TaskEntity taskEntity1 = new TaskEntity();
        taskEntity1.setId(TASK_ID);
        taskEntity1.setGlobalId(TASK_GLOBAL_ID);
        taskEntity1.setName("ReverseString");
        taskEntity1.setDescription("Please write a program to reverse the incoming string and send it to System.out\n" +
                "For example input string:  hello world,  output string: dlrow olleh");
        taskEntity1.setInputParameter("hello world");
        taskEntity1.setOutputParameter("dlrow olleh");
        taskEntities.add(taskEntity1);

        TaskEntity taskEntity2 = new TaskEntity();
        taskEntity2.setId(2L);
        taskEntity2.setGlobalId(UUID.randomUUID());
        taskEntity2.setName("DoubleString");
        taskEntity2.setDescription("Please write a program that repeats the input string one space \n" +
                "and sends it to System.out.\n" +
                "For example input string:  hello,  output string: hello hello");
        taskEntity2.setInputParameter("hello");
        taskEntity2.setOutputParameter("hello hello");

        taskEntities.add(taskEntity2);
        Mockito.when(taskRepository.findAll()).thenReturn(taskEntities);

        // execute /task/list
        MvcResult result = mockMvc.perform(get(CONTEXT_PATH + "/task/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        List<TaskModel> taskModels = objectMapper.readValue(
                result.getResponse().getContentAsString(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, TaskModel.class));


        assertFalse(taskModels.isEmpty());
        assertEquals(taskEntities.size(), taskModels.size());

        String solutionCode = readStringFromResources("SolutionReverseString.java");
        assertNotNull(solutionCode);
        assertFalse(solutionCode.isEmpty());

        String userNickName = "SuperBoy";
        TestModel testModel = new TestModel(
                userNickName,
                solutionCode,
                taskModels.get(0).getGlobalId());

        Mockito.when(taskRepository.findByGlobalId(TASK_GLOBAL_ID)).thenReturn(taskEntity1);
        Mockito.when(taskRepository.findById(TASK_ID)).thenReturn(Optional.of(taskEntity1));

        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setNickName(userNickName);
        Mockito.when(userRepository.findByNickName(userNickName)).thenReturn(userEntity);

        // execute /test/execute-and-check
        MvcResult executeAndCheckResult = mockMvc.perform(
                post(CONTEXT_PATH + "/test/execute-and-check")
                        .content(objectMapper.writeValueAsString(testModel))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Boolean aBoolean = objectMapper.readValue(
                executeAndCheckResult.getResponse().getContentAsString(), Boolean.class);

        assertTrue(aBoolean);
    }

    private String readStringFromResources(String path) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);
        Assertions.assertNotNull(inputStream);
        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    }

}

