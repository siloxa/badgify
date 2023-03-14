package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.IntegrationTest;
import io.github.shuoros.badgify.domain.model.color.HexColor;
import io.github.shuoros.badgify.domain.model.color.RgbColor;
import javax.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@IntegrationTest
public class ColorConverterServiceTests {

    private static final RgbColor RGB_COLOR = RgbColor.of(255, 255, 255);

    private static final HexColor HEX_COLOR = HexColor.of("ffffff");

    @Resource
    private ColorConverterService colorConverterService;

    @Test
    void toRgbWhenAHexColorGivenMustConvertThatHexColorToRgbColor() {
        // Act
        RgbColor convertedToRgbColor = colorConverterService.toRgb(HEX_COLOR);

        // Assert
        Assertions.assertEquals(RGB_COLOR.toString(), convertedToRgbColor.toString());
    }

    @Test
    void toRgbWhenARgbColorGivenMustJustReturnThatRgbColor() {
        // Act
        RgbColor convertedToRgbColor = colorConverterService.toRgb(RGB_COLOR);

        // Assert
        Assertions.assertEquals(RGB_COLOR, convertedToRgbColor);
    }

    @Test
    void toHexWhenARgbColorGivenMustConvertThatRgbColorToHexColor() {
        // Act
        HexColor convertedToHexColor = colorConverterService.toHex(RGB_COLOR);

        // Assert
        Assertions.assertEquals(HEX_COLOR.toString(), convertedToHexColor.toString());
    }

    @Test
    void toHexWhenAHexColorGivenMustJustReturnThatHexColor() {
        // Act
        HexColor convertedToHexColor = colorConverterService.toHex(HEX_COLOR);

        // Assert
        Assertions.assertEquals(HEX_COLOR, convertedToHexColor);
    }
}
