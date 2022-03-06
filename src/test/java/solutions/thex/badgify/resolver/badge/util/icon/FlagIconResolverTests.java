package solutions.thex.badgify.resolver.badge.util.icon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import solutions.thex.badgify.svg.resolver.badge.util.icon.FlagIconResolver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FlagIconResolverTests {

    @Test
    void resolvedPathMustBeCorrect() {
        // Given
        String countryCode = "flag.ir";

        // When
        String resolvedPath = FlagIconResolver.resolve(countryCode);

        // Then
        assertEquals("/icons/flags/ir.svg", resolvedPath);
    }

}
