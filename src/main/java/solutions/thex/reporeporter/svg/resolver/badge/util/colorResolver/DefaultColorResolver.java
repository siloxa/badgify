package solutions.thex.reporeporter.svg.resolver.badge.util.colorResolver;

import solutions.thex.reporeporter.svg.resolver.badge.util.ColorResolver;
import solutions.thex.reporeporter.svg.resolver.badge.util.DefaultColor;

import java.util.Objects;

public class DefaultColorResolver extends ColorResolver {

    public static String resolve(String color) {
        return Objects.requireNonNull(DefaultColor.getColor(color)).toString();
    }

}
