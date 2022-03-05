package solutions.thex.reporeporter.resolver.badge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import solutions.thex.reporeporter.svg.resolver.badge.IconResolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class IconResolverTests {

    private IconResolver iconResolver;

    @BeforeEach
    void setup() {
        iconResolver = new IconResolver();
    }

    @Test
    void iconResolverMustResolveSmallSizedIconPramsAndReturnCorrectIconBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "icon", "github",//
                "theme", "simple",//
                "size", "s",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        String iconBadge = iconResolver.resolve(params);

        // Then
        String orgIconBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/icon/simple-s.svg"));
        assertEquals(orgIconBadge, iconBadge);
    }

    @Test
    void iconResolverMustResolveMediumSizedIconPramsAndReturnCorrectIconBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "icon", "github",//
                "theme", "simple",//
                "size", "m",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        String iconBadge = iconResolver.resolve(params);

        // Then
        String orgIconBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/icon/simple-m.svg"));
        assertEquals(orgIconBadge, iconBadge);
    }

    @Test
    void iconResolverMustResolveLargeSizedIconPramsAndReturnCorrectIconBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "icon", "github",//
                "theme", "simple",//
                "size", "l",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        String iconBadge = iconResolver.resolve(params);

        // Then
        String orgIconBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/icon/simple-l.svg"));
        assertEquals(orgIconBadge, iconBadge);
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
