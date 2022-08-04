package solutions.thex.badgify.control.ready.statistic;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import solutions.thex.badgify.MongoDBContainerBaseTest;
import solutions.thex.badgify.dao.repository.GitHubProfileViewRepository;
import solutions.thex.badgify.dao.repository.GitHubRepositoryViewRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@Disabled
public class ViewCounterBadgeControllerTests extends MongoDBContainerBaseTest {

    @Autowired
    private GitHubProfileViewRepository gitProfileViewRepository;
    @Autowired
    private GitHubRepositoryViewRepository gitRepositoryViewRepository;
    @Autowired
    private MockMvc mvc;

    @Value("${server.port}")
    private int port;

    private final String host = "http://localhost:" + port;

    @BeforeEach
    void setUp() {
        gitProfileViewRepository.deleteAll();
        gitRepositoryViewRepository.deleteAll();
    }

    @Test
    void githubProfileViewsBadgeWhenForFirstTimeMustGenerateALTRLinkBadgeWith1ProfileViews() throws Exception {
        // Given
        String uri = host + "/api/counter/github/profile/shuoros";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/counter/profile-1.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void githubProfileViewsBadgeWhenForSecondTimeMustGenerateALTRLinkBadgeWith2ProfileViews() throws Exception {
        // Given
        String uri = host + "/api/counter/github/profile/shuoros";

        // When
        mvc.perform(// Get first time
                        MockMvcRequestBuilders.get(uri))
                .andReturn();
        MvcResult mvcResult = mvc.perform(// Get second time
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/counter/profile-2.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void githubRepositoryViewsBadgeWhenForFirstTimeMustGenerateALTRLinkBadgeWith1RepositoryViews() throws Exception {
        // Given
        String uri = host + "/api/counter/github/repo/shuoros/badgify";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/counter/repository-1.svg"));
        assertEquals(orgBadge, content);
    }

    @Test
    void githubRepositoryViewsBadgeWhenForSecondTimeMustGenerateALTRLinkBadgeWith2RepositoryViews() throws Exception {
        // Given
        String uri = host + "/api/counter/github/repo/shuoros/badgify";

        // When
        mvc.perform(// Get first time
                        MockMvcRequestBuilders.get(uri))
                .andReturn();
        MvcResult mvcResult = mvc.perform(// Get second time
                        MockMvcRequestBuilders.get(uri))
                .andReturn();

        // Then
        String content = mvcResult.getResponse().getContentAsString();
        String orgBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/counter/repository-2.svg"));
        assertEquals(orgBadge, content);
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

}
