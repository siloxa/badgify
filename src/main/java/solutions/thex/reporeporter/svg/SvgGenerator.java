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

    private String theme;
    private String title;
    private String link;
    private String width;
    private String height;
    private String color;
    private String content;
    private Path rootDirectory;

    @Override
    public String getName() {
        return "solutions.thex.reporeporter.svg";
    }

    @Override
    public File getFile() throws IOException {
        File tempFile = File.createTempFile(theme + ".svg", ".soy");
        tempFile.deleteOnExit();

        FileUtils.copyInputStreamToFile(//
                Objects.requireNonNull(//
                        getClass().getClassLoader().getResourceAsStream("templates/simple.svg.soy")),//
                tempFile);

        return tempFile;
    }

    @Override
    public Map<String, Object> getParameters() {
        return Map.of("title", title, "link", link, "width", width, "height", height,
                "color", color, "content", content);
    }

    @Override
    public Path getPath() {
        return rootDirectory.resolve("template.svg");
    }
}
