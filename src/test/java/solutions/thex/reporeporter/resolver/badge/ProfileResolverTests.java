package solutions.thex.reporeporter.resolver.badge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import solutions.thex.reporeporter.svg.resolver.badge.ProfileResolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ProfileResolverTests {

    private ProfileResolver profileResolver;

    @BeforeEach
    void setup() {
        profileResolver = new ProfileResolver();
    }

    @Test
    void profileResolverMustResolvePramsAndReturnCorrectProfileBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "id", "TheXSolutions",//
                "theme", "simple",//
                "bg", "rgb(-1, -1, -1)",//
                "color", "rgb(255, 255, 255)");

        // When
        String profileBadge = profileResolver.resolve(params);

        // Then
        String orgProfileBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/profile/simple.svg"));
        assertEquals(orgProfileBadge, profileBadge);
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
