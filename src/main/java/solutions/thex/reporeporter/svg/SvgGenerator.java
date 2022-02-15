package solutions.thex.reporeporter.svg;

import lombok.Builder;
import org.apache.commons.io.FileUtils;
import solutions.thex.reporeporter.soy.ISoyConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

@Builder
public class SvgGenerator implements ISoyConfiguration {

    private String style;
    private String theme;
    private String logo;
    private String size;
    private String direction;
    private String title;
    private String link;
    private String textLength;
    private String titleXPosition;
    private String width;
    private String height;
    private String bg;
    private String color;
    private Path rootDirectory;

    @Override
    public String getName() {
        return "solutions.thex.reporeporter.svg";
    }

    @Override
    public File getFile() throws IOException {
        File tempFile = File.createTempFile(//
                theme + "-" + size + "-" + direction + ".svg",//
                ".soy");
        tempFile.deleteOnExit();

        FileUtils.copyInputStreamToFile(//
                Objects.requireNonNull(//
                        getClass().getClassLoader().getResourceAsStream(//
                                "templates/" + style + "/"//
                                        + theme + "-" + size + "-" + direction + ".svg.soy")),//
                tempFile);

        return tempFile;
    }

    @Override
    public Map<String, Object> getParameters() {
        return Map.of(//
                "title", title,//
                "logo", logo,//
                "link", link,//
                "textLength", textLength,//
                "titleXPosition", titleXPosition,//
                "width", width,//
                "height", height,//
                "bg", bg,//
                "color", color);
    }

    @Override
    public Path getPath() {
        return rootDirectory.resolve("template.svg");
    }
}
