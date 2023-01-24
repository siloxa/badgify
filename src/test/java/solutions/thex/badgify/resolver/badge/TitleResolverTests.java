package solutions.thex.badgify.resolver.badge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import solutions.thex.badgify.svg.resolver.badge.TitleResolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TitleResolverTests {

    private TitleResolver titleResolver;

    @BeforeEach
    void setup() {
        titleResolver = new TitleResolver();
    }

    @Test
    void titleResolverMustResolveSmallSizedTitlePramsAndReturnCorrectTitleBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "badgify",//
                "theme", "simple",//
                "size", "s",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        String titleBadge = titleResolver.resolve(params);

        // Then
        String orgTitleBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/title/simple-s.svg"));
        assertEquals(orgTitleBadge, titleBadge);
    }

    @Test
    void titleResolverMustResolveMediumSizedTitlePramsAndReturnCorrectTitleBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "badgify",//
                "theme", "simple",//
                "size", "m",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        String titleBadge = titleResolver.resolve(params);

        // Then
        String orgTitleBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/title/simple-m.svg"));
        assertEquals(orgTitleBadge, titleBadge);
    }

    @Test
    void titleResolverMustResolveLargeSizedTitlePramsAndReturnCorrectTitleBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "badgify",//
                "theme", "simple",//
                "size", "l",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        String titleBadge = titleResolver.resolve(params);

        // Then
        String orgTitleBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/title/simple-l.svg"));
        assertEquals(orgTitleBadge, titleBadge);
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
