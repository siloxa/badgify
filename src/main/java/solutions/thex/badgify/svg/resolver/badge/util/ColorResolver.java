package solutions.thex.badgify.svg.resolver.badge.util;

import java.awt.*;

public class ColorResolver {

    public static String resolve(String color) {
        if ("#".concat(color).matches("^#(?:[0-9a-fA-F]{3}){1,2}$")) {
            Color rgb = hex2Rgb("#".concat(standardize3HexTo6Hex(color)));
            return rgbStringBuilder(rgb);
        }
        return color;
    }

    protected static String rgbStringBuilder(Color rgb) {
        return "rgb(" + rgb.getRed() + ", " + rgb.getGreen() + ", " + rgb.getBlue() + ")";
    }

    protected static String standardize3HexTo6Hex(String color) {
        return (color.length() == 3) ?//
                String.valueOf(color.charAt(0)) + String.valueOf(color.charAt(0)) +//
                        String.valueOf(color.charAt(1)) + String.valueOf(color.charAt(1)) +//
                        String.valueOf(color.charAt(2)) + String.valueOf(color.charAt(2)) ://
                color;
    }

    protected static Color hex2Rgb(String colorStr) {
        return Color.decode(colorStr);
    }

}
