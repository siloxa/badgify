package solutions.thex.badgify.resolver.badge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import solutions.thex.badgify.svg.resolver.badge.LTRLinkResolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class LTRLinkResolverTests {

    private LTRLinkResolver ltrLinkResolver;

    @BeforeEach
    void setup() {
        ltrLinkResolver = new LTRLinkResolver();
    }

    @Test
    void ltrLinkResolverMustResolveSmallSizedLTRLinkPramsAndReturnCorrectLTRLinkBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "badgify",//
                "icon", "github",//
                "theme", "simple",//
                "direction", "ltr",//
                "size", "s",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        String ltrLinkBadge = ltrLinkResolver.resolve(params);

        // Then
        String orgLTRLinkBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/link/simple-s-ltr.svg"));
        assertEquals(orgLTRLinkBadge, ltrLinkBadge);
    }

    @Test
    void ltrLinkResolverMustResolveMediumSizedLTRLinkPramsAndReturnCorrectLTRLinkBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "badgify",//
                "icon", "github",//
                "theme", "simple",//
                "direction", "ltr",//
                "size", "m",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        String ltrLinkBadge = ltrLinkResolver.resolve(params);

        // Then
        String orgLTRLinkBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/link/simple-m-ltr.svg"));
        assertEquals(orgLTRLinkBadge, ltrLinkBadge);
    }

    @Test
    void ltrLinkResolverMustResolveLargeSizedLTRLinkPramsAndReturnCorrectLTRLinkBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "badgify",//
                "icon", "github",//
                "theme", "simple",//
                "direction", "ltr",//
                "size", "l",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        String ltrLinkBadge = ltrLinkResolver.resolve(params);

        // Then
        String orgLTRLinkBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/link/simple-l-ltr.svg"));
        assertEquals(orgLTRLinkBadge, ltrLinkBadge);
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
