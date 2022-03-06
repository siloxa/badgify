package solutions.thex.badgify.resolver.badge.util.icon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import solutions.thex.badgify.svg.resolver.badge.util.icon.IconscoutIconResolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IconscoutIconResolverTests {

    @Test
    void resolvedPathMustBeCorrect() {
        // Given
        String countryCode = "color.github";

        // When
        String resolvedPath = IconscoutIconResolver.resolve(countryCode);

        // Then
        assertEquals("/icons/color/github.svg", resolvedPath);
    }

}
