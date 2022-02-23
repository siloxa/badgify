package solutions.thex.reporeporter.svg.generator.badge;

import lombok.Builder;
import solutions.thex.reporeporter.svg.SvgGenerator;

import java.util.Map;

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
        return "templates/logo/" + theme + "-" + size + ".svg.soy";
    }
}
