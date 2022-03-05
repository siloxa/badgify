package solutions.thex.reporeporter.svg.generator.badge;

import lombok.Builder;
import solutions.thex.reporeporter.svg.SvgGenerator;

import java.util.Map;

/**
 * An implementation of {@link solutions.thex.reporeporter.svg.SvgGenerator} which generates a icon badge SVG.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
@Builder
public class IconGenerator extends SvgGenerator {

    private String theme;
    private String size;
    private String icon;
    private String title;
    private String link;
    private String width;
    private String height;
    private String bg;

    @Override
    public Map<String, Object> getParameters() {
        System.out.println(icon + " " + title + " " + link + " " + width + " " + height + " " + bg);
        return Map.of(//
                "icon", icon,//
                "title", title,//
                "link", link,//
                "width", width,//
                "height", height,//
                "bg", bg);
    }

    @Override
    public String getTemplatePath() {
        return "templates/icon/" + theme + "-" + size + ".svg.soy";
    }

}
