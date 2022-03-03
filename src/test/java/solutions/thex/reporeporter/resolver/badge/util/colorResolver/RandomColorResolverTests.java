package solutions.thex.reporeporter.resolver.badge.util.colorResolver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import solutions.thex.reporeporter.svg.resolver.badge.util.DefaultColor;
import solutions.thex.reporeporter.svg.resolver.badge.util.colorResolver.RandomColorResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RandomColorResolverTests {

    @Test
    void randomColorResolverMustReturnARandomColorFromDefaultColors() {
        // Given
        final List<String> colorsAsRGB = new ArrayList<>();
        Arrays.asList(DefaultColor.values()).forEach(color -> {
            colorsAsRGB.add(color.toString());
        });

        // When
        String result = RandomColorResolver.resolve();

        // Then
        assertTrue(colorsAsRGB.contains(result));
    }
}
