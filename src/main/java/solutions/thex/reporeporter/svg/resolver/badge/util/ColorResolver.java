package solutions.thex.reporeporter.svg.resolver.badge.util;

import java.awt.*;
import java.util.Objects;

public class ColorResolver {

    public static String resolve(String color) {
        if (DefaultColor.getColor(color) != null) {
            return Objects.requireNonNull(DefaultColor.getColor(color)).toString();
        }
        if ("#".concat(color).matches("^#(?:[0-9a-fA-F]{3}){1,2}$")) {
            Color rgb = hex2Rgb("#".concat(standardize3HexTo6Hex(color)));
            return rgbStringBuilder(rgb);
        }
        return color;
    }

    private static String rgbStringBuilder(Color rgb) {
        return "rgb(" + rgb.getRed() + ", " + rgb.getGreen() + ", " + rgb.getBlue() + ")";
    }

    private static String standardize3HexTo6Hex(String color) {
        return (color.length() == 3) ?//
                String.valueOf(color.charAt(0)) + String.valueOf(color.charAt(0)) +//
                        String.valueOf(color.charAt(1)) + String.valueOf(color.charAt(1)) +//
                        String.valueOf(color.charAt(2)) + String.valueOf(color.charAt(2)) ://
                color;
    }

    private static Color hex2Rgb(String colorStr) {
        return Color.decode(colorStr);
    }

}
