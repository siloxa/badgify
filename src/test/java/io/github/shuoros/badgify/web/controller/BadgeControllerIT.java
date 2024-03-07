package io.github.shuoros.badgify.web.controller;

import io.github.shuoros.badgify.IntegrationTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@AutoConfigureMockMvc
@IntegrationTest
public class BadgeControllerIT {

    @Resource
    private MockMvc mockMvc;

    @ParameterizedTest
    @ArgumentsSource(BadgeControllerTestsArgumentProvider.class)
    public void badgeControllerTests(String endpoint, ResultMatcher status, MultiValueMap<String, String> params, String expectedBadgeAsSVG) throws Exception {
        mockMvc
            .perform(
                get("/api/badge/" + endpoint)
                    .queryParams(params)
                    .accept("image/svg+xml")
            )
            .andExpect(status)
            .andExpect(content().string(expectedBadgeAsSVG));
    }
}
