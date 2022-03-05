package solutions.thex.reporeporter.control;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BadgeControllerTests {

    @Value("${server.port}")
    private int port;

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private Filter springSecurityFilterChain;

    String host = "http://localhost:" + port;

    @BeforeAll
    void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilters(springSecurityFilterChain).build();
    }

    @Test
    void linkBadgeMustReturn422WhenTitleNotProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/link";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri)
                                .queryParam("icon", "github"))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(422, status);
    }

    @Test
    void linkBadgeMustReturn422WhenIconNotProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/link";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri)
                                .queryParam("title", "repo-reporter"))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(422, status);
    }

    @Test
    void linkBadgeMustReturn200WhenBothIconAndTitleProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/link";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri)
                                .queryParam("title", "repo-reporter")//
                                .queryParam("icon", "github"))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void iconBadgeMustReturn422WhenIconNotProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/icon";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(422, status);
    }

    @Test
    void iconBadgeMustReturn422WhenIconProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/icon";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri)
                                .queryParam("icon", "github"))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void titleBadgeMustReturn422WhenTitleNotProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/title";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(422, status);
    }

    @Test
    void titleBadgeMustReturn422WhenTitleProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/title";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri)
                                .queryParam("title", "repo-reporter"))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void profileBadgeMustReturn422WhenGitHubIdNotProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/profile";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(422, status);
    }

    @Test
    void profileBadgeMustReturn422WhenGitHubIdProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/profile";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri)
                                .queryParam("id", "shuoros"))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

}
