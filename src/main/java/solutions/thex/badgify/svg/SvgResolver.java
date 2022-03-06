package solutions.thex.badgify.svg;

import solutions.thex.badgify.svg.resolver.badge.util.ColorResolver;
import solutions.thex.badgify.svg.resolver.badge.util.DefaultColor;
import solutions.thex.badgify.svg.resolver.badge.util.color.DefaultColorResolver;
import solutions.thex.badgify.svg.resolver.badge.util.color.RandomColorResolver;
import solutions.thex.badgify.svg.resolver.badge.util.icon.FlagIconResolvers;
import solutions.thex.badgify.svg.resolver.badge.util.icon.FontAwesomeIconResolver;
import solutions.thex.badgify.svg.resolver.badge.util.icon.IconscoutIconResolver;

import java.io.IOException;
import java.util.Map;

/**
 * Resolves an SVG generator class based on given parameters from user by resolve method.
 * Different SVG types can implement this interface to provide their own SVG generator.
 * For example see {@link solutions.thex.badgify.svg.resolver.badge.LTRLinkResolver}.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class SvgResolver {

    public abstract String resolve(Map<String, String> params) throws IOException;

    protected String resolveIcon(String icon, String color) {
        if (icon.split("\\.").length < 2)
            return FontAwesomeIconResolver.resolve(icon, color);
        else if ("flag".equals(icon.split("\\.")[0]))
            return FlagIconResolvers.resolve(icon);
        else if ("color".equals(icon.split("\\.")[0]))
            return IconscoutIconResolver.resolve(icon);
        return "";
    }

    protected String resolveBG(String bg) {
        if (DefaultColor.getColor(bg) != null) {
            return DefaultColorResolver.resolve(bg);
        } else if ("random".equals(bg)) {
            return RandomColorResolver.resolve();
        }
        return ColorResolver.resolve(bg);
    }

    protected String resolveColor(String color, String bg) {
        if ("rgb(255, 255, 255)".equals(color)) {
            if (DefaultColor.GREEN.toString().equals(bg)) {
                return DefaultColor.BLACK.toString();
            } else if (DefaultColor.YELLOW.toString().equals(bg)) {
                return DefaultColor.BLACK.toString();
            } else if (DefaultColor.ORANGE.toString().equals(bg)) {
                return DefaultColor.BLACK.toString();
            } else if (DefaultColor.GRAY.toString().equals(bg)) {
                return DefaultColor.BLACK.toString();
            } else if (DefaultColor.LAVENDER.toString().equals(bg)) {
                return DefaultColor.BLACK.toString();
            } else if (DefaultColor.CYAN.toString().equals(bg)) {
                return DefaultColor.BLACK.toString();
            } else if (DefaultColor.WHITE.toString().equals(bg)) {
                return DefaultColor.BLACK.toString();
            }
            return DefaultColor.WHITE.toString();
        }
        if (DefaultColor.getColor(color) != null) {
            return DefaultColorResolver.resolve(color);
        } else if ("random".equals(color)) {
            return RandomColorResolver.resolve();
        }
        return ColorResolver.resolve(color);
    }

    protected String resolveTextLength(String title, String size) {
        return switch (size) {
            case "s" -> String.valueOf((int) Math.ceil(title.length() * 6.4117647) * 10);
            case "m" -> String.valueOf((int) Math.ceil(title.length() * 7.05882353) * 10);
            case "l" -> String.valueOf((int) Math.ceil(title.length() * 8.2352941) * 10);
            default -> "";
        };
    }

    protected String resolveWidth(String size, String title) {
        return switch (size) {
            case "s" -> String.valueOf((int) Math.ceil((title.length() * 6.4117647) + 29));
            case "m" -> String.valueOf((int) Math.ceil((title.length() * 7.05882353) + 33));
            case "l" -> String.valueOf((int) Math.ceil((title.length() * 8.2352941) + 40));
            default -> "";
        };
    }

    protected String resolveHeight(String size) {
        return switch (size) {
            case "s" -> "24";
            case "m" -> "29";
            case "l" -> "35";
            default -> "";
        };
    }

}
