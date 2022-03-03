package solutions.thex.reporeporter.resolver.badge.util.colorResolver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import solutions.thex.reporeporter.svg.resolver.badge.util.colorResolver.DefaultColorResolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DefaultColorResolverTests {

    @Test
    void resolveMethodMustResolveRedDefaultColorByName() {
        // Given
        String colorName = "red";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(190, 30, 45)", color);
    }

    @Test
    void resolveMethodMustResolveRedDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "ReD";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(190, 30, 45)", color);
    }

    @Test
    void resolveMethodMustResolveBlueDefaultColorByName() {
        // Given
        String colorName = "blue";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(28, 117, 188)", color);
    }

    @Test
    void resolveMethodMustResolveBlueDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "bLuE";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(28, 117, 188)", color);
    }

    @Test
    void resolveMethodMustResolveGreenDefaultColorByName() {
        // Given
        String colorName = "green";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(120, 193, 67)", color);
    }

    @Test
    void resolveMethodMustResolveGreenDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "GrEeN";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(120, 193, 67)", color);
    }

    @Test
    void resolveMethodMustResolveYellowDefaultColorByName() {
        // Given
        String colorName = "yellow";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(231, 209, 35)", color);
    }

    @Test
    void resolveMethodMustResolveYellowDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "yElLoW";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(231, 209, 35)", color);
    }

    @Test
    void resolveMethodMustResolveOrangeDefaultColorByName() {
        // Given
        String colorName = "orange";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(245, 119, 31)", color);
    }

    @Test
    void resolveMethodMustResolveOrangeDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "OrAnGe";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(245, 119, 31)", color);
    }

    @Test
    void resolveMethodMustResolvePurpleDefaultColorByName() {
        // Given
        String colorName = "purple";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(127, 63, 152)", color);
    }

    @Test
    void resolveMethodMustResolvePurpleDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "pUrPlE";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(127, 63, 152)", color);
    }

    @Test
    void resolveMethodMustResolvePinkDefaultColorByName() {
        // Given
        String colorName = "pink";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(255, 17, 125)", color);
    }

    @Test
    void resolveMethodMustResolvePinkDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "pInK";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(255, 17, 125)", color);
    }

    @Test
    void resolveMethodMustResolveBrownDefaultColorByName() {
        // Given
        String colorName = "brown";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(117, 76, 41)", color);
    }

    @Test
    void resolveMethodMustResolveBrownDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "BrOwN";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(117, 76, 41)", color);
    }

    @Test
    void resolveMethodMustResolveIndigoDefaultColorByName() {
        // Given
        String colorName = "indigo";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(38, 34, 98)", color);
    }

    @Test
    void resolveMethodMustResolveIndigoDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "iNdIgO";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(38, 34, 98)", color);
    }

    @Test
    void resolveMethodMustResolveGrayDefaultColorByName() {
        // Given
        String colorName = "gray";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(115, 115, 115)", color);
    }

    @Test
    void resolveMethodMustResolveGrayDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "GrAy";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(115, 115, 115)", color);
    }

    @Test
    void resolveMethodMustResolveLavenderDefaultColorByName() {
        // Given
        String colorName = "lavender";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(199, 153, 198)", color);
    }

    @Test
    void resolveMethodMustResolveLavenderDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "lAvEnDeR";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(199, 153, 198)", color);
    }

    @Test
    void resolveMethodMustResolveCyanDefaultColorByName() {
        // Given
        String colorName = "cyan";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(111, 204, 221)", color);
    }

    @Test
    void resolveMethodMustResolveCyanDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "CyAn";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(111, 204, 221)", color);
    }

    @Test
    void resolveMethodMustResolveBlackDefaultColorByName() {
        // Given
        String colorName = "black";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(0, 0, 0)", color);
    }

    @Test
    void resolveMethodMustResolveBlackDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "bLaCk";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(0, 0, 0)", color);
    }

    @Test
    void resolveMethodMustResolveWhiteDefaultColorByName() {
        // Given
        String colorName = "white";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(255, 255, 255)", color);
    }

    @Test
    void resolveMethodMustResolveWhiteDefaultColorByNameAndBeCaseInsensitive() {
        // Given
        String colorName = "WhItE";

        // When
        String color = DefaultColorResolver.resolve(colorName);

        // Then
        assertEquals("rgb(255, 255, 255)", color);
    }

}
