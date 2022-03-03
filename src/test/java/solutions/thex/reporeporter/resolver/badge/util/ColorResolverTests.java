package solutions.thex.reporeporter.resolver.badge.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import solutions.thex.reporeporter.svg.resolver.badge.util.ColorResolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ColorResolverTests {

    @Test
    void resolveMethodMustResolveHexColor() {
        // Given
        String colorName = "ff0000";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(255, 0, 0)", color);
    }

    @Test
    void resolveMethodMustResolveHexColorWithUpperCase() {
        // Given
        String colorName = "FF0000";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(255, 0, 0)", color);
    }

    @Test
    void resolveMethodMustResolveHexColorWithShortHex() {
        // Given
        String colorName = "f00";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(255, 0, 0)", color);
    }

    @Test
    void resolveMethodMustResolveHexColorWithShortHexWithUpperCase() {
        // Given
        String colorName = "F00";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(255, 0, 0)", color);
    }

}
