package solutions.thex.badgify.svg.generator.badge;

import lombok.Builder;
import solutions.thex.badgify.svg.SvgGenerator;

import java.util.Map;

/**
 * An implementation of {@link solutions.thex.badgify.svg.SvgGenerator} which generates a title badge SVG.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
@Builder
public class TitleGenerator extends SvgGenerator {

    private String theme;
    private String size;
    private String title;
    private String link;
    private String textLength;
    private String titleXPosition;
    private String width;
    private String height;
    private String bg;
    private String color;

    @Override
    public Map<String, Object> getParameters() {
        return Map.of(//
                "title", title, //
                "link", link, //
                "textLength", textLength, //
                "titleXPosition", titleXPosition, //
                "width", width, //
                "height", height, //
                "bg", bg, //
                "color", color);
    }

    @Override
    public String getTemplatePath() {
        return "templates/title/" + theme + "-" + size + ".svg.soy";
    }

}
