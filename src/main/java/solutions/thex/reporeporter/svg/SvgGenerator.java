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

    @Builder.Default
    private String style = "-1";
    @Builder.Default
    private String theme = "-1";
    @Builder.Default
    private String logo = "-1";
    @Builder.Default
    private String size = "-1";
    @Builder.Default
    private String direction = "-1";
    @Builder.Default
    private String title = "-1";
    @Builder.Default
    private String link = "-1";
    @Builder.Default
    private String textLength = "-1";
    @Builder.Default
    private String titleXPosition = "-1";
    @Builder.Default
    private String logoXPosition = "-1";
    @Builder.Default
    private String width = "-1";
    @Builder.Default
    private String height = "-1";
    @Builder.Default
    private String bg = "-1";
    @Builder.Default
    private String color = "-1";
    @Builder.Default
    private String avatar = "-1";
    @Builder.Default
    private String id = "-1";
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

        loadTemplateIn(tempFile);

        return tempFile;
    }

    @Override
    public Map<String, Object> getParameters() {
        return Map.ofEntries(//
                Map.entry("title", title),//
                Map.entry("logo", logo),//
                Map.entry("link", link),//
                Map.entry("textLength", textLength),//
                Map.entry("titleXPosition", titleXPosition),//
                Map.entry("logoXPosition", logoXPosition),//
                Map.entry("width", width),//
                Map.entry("height", height),//
                Map.entry("bg", bg),//
                Map.entry("color", color),//
                Map.entry("avatar", avatar),//
                Map.entry("id", id));
    }

    @Override
    public Path getPath() {
        return rootDirectory.resolve("template.svg");
    }

    private void loadTemplateIn(File tempFile) throws IOException {
        FileUtils.copyInputStreamToFile(//
                Objects.requireNonNull(//
                        getClass().getClassLoader().getResourceAsStream(//
                                getTemplatePath())),//
                tempFile);
    }

    private String getTemplatePath() {
        return switch (style) {
            case "badge" -> "templates/" + style + "/"//
                    + theme + "-" + size + "-" + direction + ".svg.soy";
            case "logo", "title" -> "templates/" + style + "/"//
                    + theme + "-" + size + ".svg.soy";
            case "profile" -> "templates/" + style + "/"//
                    + theme + ".svg.soy";
            default -> "";
        };
    }

}
