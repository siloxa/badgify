package solutions.thex.badgify.resolver.badge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import solutions.thex.badgify.svg.resolver.badge.RTLLinkResolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class RTLLinkResolverTests {

    private RTLLinkResolver rtlLinkResolver;

    @BeforeEach
    void setup() {
        rtlLinkResolver = new RTLLinkResolver();
    }

    @Test
    void rtlLinkResolverMustResolveSmallSizedRTLLinkPramsAndReturnCorrectRTLLinkBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "badgify",//
                "icon", "github",//
                "theme", "simple",//
                "direction", "rtl",//
                "size", "s",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        String rtlLinkBadge = rtlLinkResolver.resolve(params);

        // Then
        String orgRTLLinkBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/link/simple-s-rtl.svg"));
        assertEquals(orgRTLLinkBadge, rtlLinkBadge);
    }

    @Test
    void rtlLinkResolverMustResolveMediumSizedRTLLinkPramsAndReturnCorrectRTLLinkBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "badgify",//
                "icon", "github",//
                "theme", "simple",//
                "direction", "rtl",//
                "size", "m",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        String rtlLinkBadge = rtlLinkResolver.resolve(params);

        // Then
        String orgRTLLinkBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/link/simple-m-rtl.svg"));
        assertEquals(orgRTLLinkBadge, rtlLinkBadge);
    }

    @Test
    void rtlLinkResolverMustResolveLargeSizedRTLLinkPramsAndReturnCorrectRTLLinkBadge() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "badgify",//
                "icon", "github",//
                "theme", "simple",//
                "direction", "rtl",//
                "size", "l",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        String rtlLinkBadge = rtlLinkResolver.resolve(params);

        // Then
        String orgRTLLinkBadge = readFromInputStream(
                getClass().getClassLoader().getResourceAsStream("static/link/simple-l-rtl.svg"));
        assertEquals(orgRTLLinkBadge, rtlLinkBadge);
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
