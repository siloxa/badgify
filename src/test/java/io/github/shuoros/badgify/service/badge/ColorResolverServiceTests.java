package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.IntegrationTest;
import io.github.shuoros.badgify.domain.enumeration.DefaultColor;
import io.github.shuoros.badgify.domain.model.color.AbstractColor;
import io.github.shuoros.badgify.domain.model.color.HexColor;
import io.github.shuoros.badgify.domain.model.color.RgbColor;
import io.github.shuoros.badgify.domain.model.errors.InvalidColorException;
import javax.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@IntegrationTest
public class ColorResolverServiceTests {

    private static final String RGB = "255,255,255";

    private static final String HEX = "ffffff";

    private static final String RANDOM = "random";

    private static final DefaultColor DEFAULT_COLOR = DefaultColor.LAVENDER;

    private static final String NONSENSE = "nonsense";

    @Resource
    private ColorResolverService colorResolverService;

    @Test
    void resolveWhenTheGivenStringIsRgbColorMustReturnARgbColorInstance() {
        // Act
        AbstractColor resolvedColor = colorResolverService.resolve(RGB);

        // Assert
        Assertions.assertInstanceOf(RgbColor.class, resolvedColor);
        Assertions.assertEquals("rgb(" + RGB + ")", resolvedColor.toString());
    }

    @Test
    void resolveWhenTheGivenStringIsHexColorMustReturnAHexColorInstance() {
        // Act
        AbstractColor resolvedColor = colorResolverService.resolve(HEX);

        // Assert
        Assertions.assertInstanceOf(HexColor.class, resolvedColor);
        Assertions.assertEquals("#" + HEX, resolvedColor.toString());
    }

    @Test
    void resolveWhenTheGivenStringIsRandomMustReturnARgbColorInstanceWithOneOfDefaultColorValue() {
        // Act
        AbstractColor resolvedColor = colorResolverService.resolve(RANDOM);

        // Assert
        Assertions.assertInstanceOf(RgbColor.class, resolvedColor);
        Assertions.assertFalse(resolvedColor.toString().isEmpty());
    }

    @Test
    void resolveWhenTheGivenStringIsOneOfDefaultColorsMustReturnARgbColorInstanceWithThatDefaultColorValue() {
        // Act
        AbstractColor resolvedColor = colorResolverService.resolve(DEFAULT_COLOR.toString());

        // Assert
        Assertions.assertInstanceOf(RgbColor.class, resolvedColor);
        Assertions.assertEquals(DEFAULT_COLOR.getColor(), resolvedColor);
    }

    @Test
    void resolveWhenTheGivenStringIsNonsenseMustThrowInvalidColorException() {
        // Act & Assert
        Assertions.assertThrows(InvalidColorException.class, () -> colorResolverService.resolve(NONSENSE));
    }
}
