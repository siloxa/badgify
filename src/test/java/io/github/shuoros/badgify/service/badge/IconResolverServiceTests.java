package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.IntegrationTest;
import io.github.shuoros.badgify.domain.model.errors.InvalidIconException;
import io.github.shuoros.badgify.domain.model.icon.AbstractIcon;
import io.github.shuoros.badgify.domain.model.icon.FlagIcon;
import io.github.shuoros.badgify.domain.model.icon.FontAwesomeIcon;
import javax.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@IntegrationTest
public class IconResolverServiceTests {

    private static final String FONT_AWESOME_ICON = "github";

    private static final String FLAG_ICON = "flag.de";

    private static final String NONSENSE = "nonsense";

    @Resource
    private IconResolverService iconResolverService;

    @Test
    void resolveWhenAFontAwesomeIconGivenMustReturnAFontAwesomeIconInstanceWithIconName() {
        // Act
        AbstractIcon resolvedIcon = iconResolverService.resolve(FONT_AWESOME_ICON);

        // Assert
        Assertions.assertInstanceOf(FontAwesomeIcon.class, resolvedIcon);
        Assertions.assertEquals(FONT_AWESOME_ICON, resolvedIcon.getName());
        Assertions.assertNull(resolvedIcon.toString());
    }

    @Test
    void resolveWhenAFlagIconGivenMustReturnAFlagIconInstanceWithIconName() {
        // Act
        AbstractIcon resolvedIcon = iconResolverService.resolve(FLAG_ICON);

        // Assert
        Assertions.assertInstanceOf(FlagIcon.class, resolvedIcon);
        Assertions.assertEquals(FLAG_ICON, resolvedIcon.getName());
        Assertions.assertNull(resolvedIcon.toString());
    }

    @Test
    void resolveWhenANonsenseGivenMustThrowInvalidIconException() {
        // Act & Assert
        Assertions.assertThrows(InvalidIconException.class, () -> iconResolverService.resolve(NONSENSE));
    }
}
