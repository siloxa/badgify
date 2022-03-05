package solutions.thex.reporeporter.svg.generator.badge;

import lombok.Builder;
import solutions.thex.reporeporter.svg.SvgGenerator;

import java.util.Map;

/**
 * An implementation of {@link solutions.thex.reporeporter.svg.SvgGenerator} which generates an RTL link badge SVG.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
@Builder
public class RTLLinkGenerator extends SvgGenerator {

    private String theme;
    private String size;
    private String direction;
    private String title;
    private String icon;
    private String link;
    private String textLength;
    private String titleXPosition;
    private String iconXPosition;
    private String width;
    private String height;
    private String bg;
    private String color;

    @Override
    public Map<String, Object> getParameters() {
        return Map.of(//
                "title", title, //
                "icon", icon, //
                "link", link, //
                "textLength", textLength, //
                "titleXPosition", titleXPosition, //
                "iconXPosition", iconXPosition, //
                "width", width, //
                "height", height, //
                "bg", bg, //
                "color", color);
    }

    @Override
    public String getTemplatePath() {
        return "templates/link/" + theme + "-" + size + "-rtl.svg.soy";
    }

}
