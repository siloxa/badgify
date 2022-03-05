package solutions.thex.badgify.svg.generator.badge;

import lombok.Builder;
import solutions.thex.badgify.svg.SvgGenerator;

import java.util.Map;

/**
 * An implementation of {@link solutions.thex.badgify.svg.SvgGenerator} which generates a profile badge SVG.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
@Builder
public class ProfileGenerator extends SvgGenerator {

    private String theme;
    private String title;
    private String link;
    private String width;
    private String bg;
    private String color;
    private String id;
    private String avatar;

    @Override
    public Map<String, Object> getParameters() {
        return Map.of(//
                "title", title,//
                "link", link,//
                "width", width,//
                "bg", bg,//
                "color", color,//
                "id", id,//
                "avatar", avatar);
    }

    @Override
    public String getTemplatePath() {
        return "templates/profile/" + theme + ".svg.soy";
    }

}
