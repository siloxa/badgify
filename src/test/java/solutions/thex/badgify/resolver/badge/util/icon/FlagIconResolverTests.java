package solutions.thex.badgify.resolver.badge.util.icon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import solutions.thex.badgify.svg.resolver.badge.util.icon.FlagIconResolver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FlagIconResolverTests {

    @Test
    void resolvedFlagMustHaveDataDeclarationPrefix() {
        // Given
        String countryCode = "flag.ir";

        // When
        String resolvedIcon = FlagIconResolver.resolve(countryCode);

        // Then
        assertTrue(resolvedIcon.startsWith("data:image/svg+xml;base64,"));
    }

}
