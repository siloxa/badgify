package solutions.thex.badgify.svg;

import solutions.thex.badgify.svg.resolver.badge.util.ColorResolver;
import solutions.thex.badgify.svg.resolver.badge.util.DefaultColor;
import solutions.thex.badgify.svg.resolver.badge.util.color.DefaultColorResolver;
import solutions.thex.badgify.svg.resolver.badge.util.color.RandomColorResolver;
import solutions.thex.badgify.svg.resolver.badge.util.icon.FlagIconResolver;
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
 * @version 1.2.0
 * @since 1.0.0
 */
public abstract class SvgResolver {

    public abstract String resolve(Map<String, String> params) throws IOException;

    /**
     * Resolves an IconResolver class based on given parameters from user by resolve method.
     *
     * @param icon  name and type of icon "font-awesome" or "iconscout" or "flag"
     * @param color color of icon. Just for "font-awesome" icons.
     * @return String of icon. It can be svg code of icon if requested icon is "font-awesome". For two other just path
     * of desired icon will be returned.
     */
    protected String resolveIcon(String icon, String color) {
        if (icon.split("\\.").length < 2)
            return FontAwesomeIconResolver.resolve(icon, color);
        else if ("flag".equals(icon.split("\\.")[0]))
            return FlagIconResolver.resolve(icon);
        else if ("color".equals(icon.split("\\.")[0]))
            return IconscoutIconResolver.resolve(icon);
        return "";
    }

    /**
     * Resolves a ColorResolver class based on given parameters from user by resolve method.
     *
     * @param bg background color of badge. If it was one of the default color then
     *           {@link solutions.thex.badgify.svg.resolver.badge.util.color.DefaultColorResolver} will resolve it.
     *           If it was random then {@link solutions.thex.badgify.svg.resolver.badge.util.color.RandomColorResolver}
     *           will resolve it. Otherwise, it will be resolved by
     *           {@link solutions.thex.badgify.svg.resolver.badge.util.ColorResolver}
     * @return String of color in form of rgb(r,g,b).
     */
    protected String resolveBG(String bg) {
        if (DefaultColor.getColor(bg) != null) {
            return DefaultColorResolver.resolve(bg);
        } else if ("random".equals(bg)) {
            return RandomColorResolver.resolve();
        }
        return ColorResolver.resolve(bg);
    }

    /**
     * Resolves text color base on background color if and only if user doesn't specify text color.
     *
     * @param color text color of badge. "rgb(255, 255, 255)" is default color.
     * @param bg    background color of badge.
     * @return String of text color in form of rgb(r,g,b).
     */
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

    /**
     * This method adds a layer on top of resolveColor method. If theme of badge was "edge" then the text color must
     * be equal to background color.
     *
     * @param text text of badge.
     * @return String of text.
     */
    protected String getColor(Map<String, String> params, String bg) {
        return "edge".equals(params.get("theme")) ? bg : resolveColor(params.get("color"), bg);
    }

}
