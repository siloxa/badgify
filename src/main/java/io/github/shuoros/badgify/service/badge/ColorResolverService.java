package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.enumeration.DefaultColor;
import io.github.shuoros.badgify.domain.model.color.AbstractColor;
import io.github.shuoros.badgify.domain.model.color.HexColor;
import io.github.shuoros.badgify.domain.model.color.RgbColor;
import io.github.shuoros.badgify.domain.model.errors.InvalidColorException;
import java.util.Objects;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class ColorResolverService {

    private static final String RGB_REGEX = "^(\\d{1,3},\\d{1,3},\\d{1,3})$";

    private static final String HEX_REGEX = "^(?:[0-9a-fA-F]{3}){1,2}$";

    public AbstractColor resolve(String color) {
        if (color.matches(RGB_REGEX)) {
            return resolveRgb(color);
        } else if (color.matches(HEX_REGEX)) {
            return resolveHex(color);
        } else if ("random".equalsIgnoreCase(color)) {
            return resolveRandomColor(color);
        } else if (DefaultColor.findByName(color) != null) {
            return Objects.requireNonNull(DefaultColor.findByName(color)).getColor();
        }
        throw new InvalidColorException();
    }

    private RgbColor resolveRgb(String color) {
        final String[] rgbValues = color.split(",");
        return RgbColor
            .builder()
            .r(Integer.parseInt(rgbValues[0]))
            .g(Integer.parseInt(rgbValues[1]))
            .b(Integer.parseInt(rgbValues[2]))
            .build();
    }

    private HexColor resolveHex(String color) {
        return HexColor.builder().value(color).build();
    }

    private RgbColor resolveRandomColor(String color) {
        final Random random = new Random();
        return DefaultColor.values()[random.nextInt(DefaultColor.values().length)].getColor();
    }
}
