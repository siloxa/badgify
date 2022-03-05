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
public class InlineBadgeControllerTests {

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
    void linkBadgeMustReturn422WhenOneOfParamsNotProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/link";
        // missing icon param for example
        uri += "/ltr_s_simple_repo-reporter_black_white_thex.solutions";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(422, status);
    }

    @Test
    void linkBadgeMustReturn200WhenAllParamsProvidedWithWhiteSpaceSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/link";
        uri += "/ltr s simple repo-reporter github black white thex.solutions";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void linkBadgeMustReturn200WhenAllParamsProvidedWithUnderLineSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/link";
        uri += "/ltr_s_simple_repo-reporter_github_black_white_thex.solutions";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void linkBadgeMustReturn200WhenAllParamsProvidedWithHyphenSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/link";
        uri += "/ltr-s-simple-repo_reporter-github-black-white-thex.solutions";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void shortLinkBadgeMustReturn422WhenOneOfParamsNotProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/link";
        // missing icon param for example
        uri += "/repo-reporter_black_white";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(422, status);
    }

    @Test
    void shortLinkBadgeMustReturn200WhenAllParamsProvidedWithWhiteSpaceSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/link";
        uri += "/repo-reporter github black s";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void shortLinkBadgeMustReturn200WhenAllParamsProvidedWithUnderLineSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/link";
        uri += "/repo-reporter_github_black_s";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void shortLinkBadgeMustReturn200WhenAllParamsProvidedWithHyphenSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/link";
        uri += "/repo_reporter-github-black-s";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void iconBadgeMustReturn422WhenOneOfParamsNotProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/icon";
        // missing icon param for example
        uri += "/s_simple_black_white_thex.solutions";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(422, status);
    }

    @Test
    void iconBadgeMustReturn200WhenAllParamsProvidedWithWhiteSpaceSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/icon";
        uri += "/s simple github black white thex.solutions";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void iconBadgeMustReturn200WhenAllParamsProvidedWithUnderLineSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/icon";
        uri += "/s_simple_github_black_white_thex.solutions";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void iconBadgeMustReturn200WhenAllParamsProvidedWithHyphenSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/icon";
        uri += "/s-simple-github-black-white-thex.solutions";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void shortIconBadgeMustReturn422WhenOneOfParamsNotProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/icon";
        // missing icon param for example
        uri += "/black_white";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(422, status);
    }

    @Test
    void shortIconBadgeMustReturn200WhenAllParamsProvidedWithWhiteSpaceSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/icon";
        uri += "/github black s";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void shortIconBadgeMustReturn200WhenAllParamsProvidedWithUnderLineSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/icon";
        uri += "/github_black_s";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void shortIconBadgeMustReturn200WhenAllParamsProvidedWithHyphenSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/icon";
        uri += "/github-black-s";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void titleBadgeMustReturn422WhenOneOfParamsNotProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/title";
        // missing title param for example
        uri += "/s_simple_black_white_thex.solutions";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(422, status);
    }

    @Test
    void titleBadgeMustReturn200WhenAllParamsProvidedWithWhiteSpaceSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/title";
        uri += "/s simple repo-reporter black white thex.solutions";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void titleBadgeMustReturn200WhenAllParamsProvidedWithUnderLineSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/title";
        uri += "/s_simple_repo-reporter_black_white_thex.solutions";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void titleBadgeMustReturn200WhenAllParamsProvidedWithHyphenSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/title";
        uri += "/s-simple-repo_reporter-black-white-thex.solutions";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void shortTitleBadgeMustReturn422WhenOneOfParamsNotProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/title";
        // missing title param for example
        uri += "/black_white";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(422, status);
    }

    @Test
    void shortTitleBadgeMustReturn200WhenAllParamsProvidedWithWhiteSpaceSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/title";
        uri += "/repo-reporter black s";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void shortTitleBadgeMustReturn200WhenAllParamsProvidedWithUnderLineSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/title";
        uri += "/repo-reporter_black_s";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void shortTitleBadgeMustReturn200WhenAllParamsProvidedWithHyphenSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/title";
        uri += "/repo_reporter-black-s";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void profileBadgeMustReturn422WhenOneOfParamsNotProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/profile";
        // missing id param for example
        uri += "/simple_black_white";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(422, status);
    }

    @Test
    void profileBadgeMustReturn200WhenAllParamsProvidedWithWhiteSpaceSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/profile";
        uri += "/simple TheXSolutions black white";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void profileBadgeMustReturn200WhenAllParamsProvidedWithUnderLineSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/profile";
        uri += "/simple_TheXSolutions_black_white";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void profileBadgeMustReturn200WhenAllParamsProvidedWithHyphenSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/profile";
        uri += "/simple-TheXSolutions-black-white";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void shortProfileBadgeMustReturn422WhenOneOfParamsNotProvided() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/profile";
        // missing id param for example
        uri += "/black_white";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(422, status);
    }

    @Test
    void shortProfileBadgeMustReturn200WhenAllParamsProvidedWithWhiteSpaceSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/profile";
        uri += "/TheXSolutions black white";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void shortProfileBadgeMustReturn200WhenAllParamsProvidedWithUnderLineSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/profile";
        uri += "/TheXSolutions_black_white";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void shortProfileBadgeMustReturn200WhenAllParamsProvidedWithHyphenSplitter() throws Exception {
        // Given
        String uri = host + "/api/badge/inline/short/profile";
        uri += "/TheXSolutions-black-white";

        // When
        MvcResult mvcResult = mvc.perform(//
                        MockMvcRequestBuilders.get(uri))//
                .andReturn();

        // Then
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

}
