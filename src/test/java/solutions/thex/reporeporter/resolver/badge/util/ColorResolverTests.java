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
    void resolveMethodMustResolveRedDefaultColorByName() {
        // Given
        String colorName = "red";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(147, 2, 0)", color);
    }

    @Test
    void resolveMethodMustResolveRedDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "ReD";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(147, 2, 0)", color);
    }

    @Test
    void resolveMethodMustResolveBlueDefaultColorByName() {
        // Given
        String colorName = "blue";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(15, 127, 191)", color);
    }

    @Test
    void resolveMethodMustResolveBlueDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "bLuE";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(15, 127, 191)", color);
    }

    @Test
    void resolveMethodMustResolveGreenDefaultColorByName() {
        // Given
        String colorName = "green";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(121, 181, 16)", color);
    }

    @Test
    void resolveMethodMustResolveGreenDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "GrEeN";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(121, 181, 16)", color);
    }

    @Test
    void resolveMethodMustResolveYellowDefaultColorByName() {
        // Given
        String colorName = "yellow";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(204, 174, 4)", color);
    }

    @Test
    void resolveMethodMustResolveYellowDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "yElLoW";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(204, 174, 4)", color);
    }

    @Test
    void resolveMethodMustResolveOrangeDefaultColorByName() {
        // Given
        String colorName = "orange";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(219, 132, 0)", color);
    }

    @Test
    void resolveMethodMustResolveOrangeDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "OrAnGe";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(219, 132, 0)", color);
    }

    @Test
    void resolveMethodMustResolvePurpleDefaultColorByName() {
        // Given
        String colorName = "purple";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(120, 17, 64)", color);
    }

    @Test
    void resolveMethodMustResolvePurpleDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "pUrPlE";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(120, 17, 64)", color);
    }

    @Test
    void resolveMethodMustResolvePinkDefaultColorByName() {
        // Given
        String colorName = "pink";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(184, 17, 159)", color);
    }

    @Test
    void resolveMethodMustResolvePinkDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "pInK";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(184, 17, 159)", color);
    }

    @Test
    void resolveMethodMustResolveGreyDefaultColorByName() {
        // Given
        String colorName = "grey";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(115, 115, 115)", color);
    }

    @Test
    void resolveMethodMustResolveGreyDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "GrEy";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(115, 115, 115)", color);
    }

    @Test
    void resolveMethodMustResolveBlackDefaultColorByName() {
        // Given
        String colorName = "black";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(0, 0, 0)", color);
    }

    @Test
    void resolveMethodMustResolveBlackDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "bLaCk";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(0, 0, 0)", color);
    }

    @Test
    void resolveMethodMustResolveWhiteDefaultColorByName() {
        // Given
        String colorName = "white";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(255, 255, 255)", color);
    }

    @Test
    void resolveMethodMustResolveWhiteDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "WhItE";

        // When
        String color = ColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(255, 255, 255)", color);
    }

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
