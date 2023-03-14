package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.model.color.AbstractColor;
import io.github.shuoros.badgify.domain.model.color.HexColor;
import io.github.shuoros.badgify.domain.model.color.RgbColor;
import org.springframework.stereotype.Service;

@Service
public class ColorConverterService {

    public RgbColor toRgb(AbstractColor color) {
        if (color instanceof HexColor) return RgbColor
            .builder()
            .r(Integer.parseInt(color.toString().substring(1, 3), 16))
            .g(Integer.parseInt(color.toString().substring(3, 5), 16))
            .b(Integer.parseInt(color.toString().substring(5, 7), 16))
            .build();
        return (RgbColor) color;
    }

    public HexColor toHex(AbstractColor color) {
        if (color instanceof RgbColor) return HexColor
            .builder()
            .value(
                Integer.toHexString(((RgbColor) color).getR()) +
                Integer.toHexString(((RgbColor) color).getG()) +
                Integer.toHexString(((RgbColor) color).getB())
            )
            .build();
        return (HexColor) color;
    }
}
