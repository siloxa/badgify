package solutions.thex.badgify.resolver.badge.util.icon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import solutions.thex.badgify.svg.resolver.badge.util.icon.FontAwesomeIconResolver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FontAwesomeIconResolverTests {

    @Test
    void resolvedIconMustHaveDataDeclarationPrefix() {
        // Given
        String icon = "github";
        String color = "rgb(255, 255, 255)";

        // When
        String resolvedIcon = FontAwesomeIconResolver.resolve(icon, color);

        // Then
        assertTrue(resolvedIcon.startsWith("data:image/svg+xml;utf-8,"));
    }

    @Test
    void resolvedIconMustFilledByGivenColor(){
        // Given
        String icon = "github";
        String color = "rgb(255, 255, 255)";

        // When
        String resolvedIcon = FontAwesomeIconResolver.resolve(icon, color);

        // Then
        assertTrue(resolvedIcon.contains("fill=&amp;quot;" + color + "&amp;quot;"));
    }

    @Test
    void resolvedIconMustNotHaveSpecialCharacters() {
        // Given
        String icon = "github";
        String color = "rgb(255, 255, 255)";

        // When
        String resolvedIcon = FontAwesomeIconResolver.resolve(icon, color);

        // Then
        assertFalse(resolvedIcon.contains("\""));
        assertFalse(resolvedIcon.contains("'"));
        assertFalse(resolvedIcon.contains("<"));
        assertFalse(resolvedIcon.contains(">"));
    }

}
