package solutions.thex.reporeporter.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegexTests {

    @Test
    void matchesMethodMustReturnAllParamsForASplitterRegexPattern() {
        // Given
        String regex = "[^ ]+";
        String params = "param1 param2 param3";

        // When
        ArrayList<String> result = new ArrayList<>();
        Regex.builder().pattern(regex).build().matches(params).forEach(matchResult -> {
            result.add(matchResult.group());
        });

        // Then
        assertEquals(3, result.size());
        assertEquals(Arrays.asList("param1", "param2", "param3"), result);
    }

}
