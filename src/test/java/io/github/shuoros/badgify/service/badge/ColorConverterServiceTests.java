package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.IntegrationTest;
import io.github.shuoros.badgify.domain.model.color.HexColor;
import io.github.shuoros.badgify.domain.model.color.RgbColor;
import javax.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@IntegrationTest
public class ColorConverterServiceTests {

    @Resource
    private ColorConverterService colorConverterService;

    private static final RgbColor rgbColor = RgbColor.of(255, 255, 255);

    private static final HexColor hexColor = HexColor.of("ffffff");

    @Test
    void toRgbWhenAHexColorGivenMustConvertThatHexColorToRgbColor() {
        // Act
        RgbColor convertedToRgbColor = colorConverterService.toRgb(hexColor);

        // Assert
        Assertions.assertEquals(rgbColor.toString(), convertedToRgbColor.toString());
    }

    @Test
    void toRgbWhenARgbColorGivenMustJustReturnThatRgbColor() {
        // Act
        RgbColor convertedToRgbColor = colorConverterService.toRgb(rgbColor);

        // Assert
        Assertions.assertEquals(rgbColor, convertedToRgbColor);
    }

    @Test
    void toHexWhenARgbColorGivenMustConvertThatRgbColorToHexColor() {
        // Act
        HexColor convertedToHexColor = colorConverterService.toHex(rgbColor);

        // Assert
        Assertions.assertEquals(hexColor.toString(), convertedToHexColor.toString());
    }

    @Test
    void toHexWhenAHexColorGivenMustJustReturnThatHexColor() {
        // Act
        HexColor convertedToHexColor = colorConverterService.toHex(hexColor);

        // Assert
        Assertions.assertEquals(hexColor, convertedToHexColor);
    }
}
