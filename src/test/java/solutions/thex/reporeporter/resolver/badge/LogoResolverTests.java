package solutions.thex.reporeporter.resolver.badge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import solutions.thex.reporeporter.svg.resolver.badge.LogoResolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class LogoResolverTests {

    private LogoResolver logoResolver;

    @BeforeEach
    void setup() {
        logoResolver = new LogoResolver();
    }

    @Test
    void logoResolverMustResolveSmallSizedLogoPramsAndReturnCorrectLogoBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "logo", "github",//
                "theme", "simple",//
                "size", "s",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        String logoBadge = logoResolver.resolve(params);

        // Then
        String orgLogoBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/logo/simple-s.svg"));
        assertEquals(orgLogoBadge, logoBadge);
    }

    @Test
    void logoResolverMustResolveMediumSizedLogoPramsAndReturnCorrectLogoBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "logo", "github",//
                "theme", "simple",//
                "size", "m",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        String logoBadge = logoResolver.resolve(params);

        // Then
        String orgLogoBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/logo/simple-m.svg"));
        assertEquals(orgLogoBadge, logoBadge);
    }

    @Test
    void logoResolverMustResolveLargeSizedLogoPramsAndReturnCorrectLogoBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "logo", "github",//
                "theme", "simple",//
                "size", "l",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        String logoBadge = logoResolver.resolve(params);

        // Then
        String orgLogoBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/logo/simple-l.svg"));
        assertEquals(orgLogoBadge, logoBadge);
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
