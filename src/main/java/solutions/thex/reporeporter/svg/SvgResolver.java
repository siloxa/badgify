package solutions.thex.reporeporter.svg;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class SvgResolver {

    public abstract String resolve(Map<String, String> params) throws IOException;

    protected String resolveLogo(String logo, String color) {
        String file = retrieveLogoFile(logo);
        file = fillColor(color, file);
        file = replaceScapeChars(file);
        return file;
    }

    private String retrieveLogoFile(String logo) {
        return new BufferedReader(//
                new InputStreamReader(//
                        Objects.requireNonNull(//
                                Thread.currentThread().getContextClassLoader()//
                                        .getResourceAsStream("static/logos/" + logo + ".svg")),
                        StandardCharsets.UTF_8)).lines()//
                .collect(Collectors.joining("\n"));
    }

    private String fillColor(String color, String file) {
        String start = file.substring(0, file.indexOf("<path") + 6);
        String end = file.substring(file.indexOf("<path") + 5);
        color = "fill=\"" + colorResolver(color) + "\"";
        return start + color + end;
    }

    private String replaceScapeChars(String file) {
        file = file.replaceAll("\"", "&quot;");
        file = file.replaceAll("'", "&apos;");
        file = file.replaceAll("<", "&lt;");
        file = file.replaceAll(">", "&gt;");
        file = file.replaceAll("&", "&amp;");
        return file;
    }

    protected String resolveTextLength(String title, String size) {
        return switch (size) {
            case "s" -> String.valueOf((int) Math.ceil(title.length() * 6.4117647) * 10);
            case "m" -> String.valueOf((int) Math.ceil(title.length() * 7.05882353) * 10);
            case "l" -> String.valueOf((int) Math.ceil(title.length() * 8.2352941) * 10);
            default -> "";
        };
    }

    protected String resolveWidth(String width, String size, String title) {
        if ("-1".equals(width))
            return extractWidthDefaultValue(size, title);
        return width;
    }

    protected String resolveHeight(String height, String size) {
        if ("-1".equals(height))
            return extractHeightDefaultValue(size);
        return height;
    }

    private String extractWidthDefaultValue(String size, String title) {
        return switch (size) {
            case "s" -> String.valueOf((int) Math.ceil((title.length() * 6.4117647) + 29));
            case "m" -> String.valueOf((int) Math.ceil((title.length() * 7.05882353) + 33));
            case "l" -> String.valueOf((int) Math.ceil((title.length() * 8.2352941) + 40));
            default -> "";
        };
    }

    private String extractHeightDefaultValue(String size) {
        return switch (size) {
            case "s" -> "24";
            case "m" -> "29";
            case "l" -> "35";
            default -> "";
        };
    }

    protected String colorResolver(String color) {
        if ("#".concat(color).matches("^#(?:[0-9a-fA-F]{3}){1,2}$")) {
            Color rgb = hex2Rgb("#".concat(standardize3HexTo6Hex(color)));
            return rgbStringBuilder(rgb);
        }
        return color;
    }

    private String rgbStringBuilder(Color rgb) {
        return "rgb(" + rgb.getRed() + "," + rgb.getGreen() + "," + rgb.getBlue() + ")";
    }

    private String standardize3HexTo6Hex(String color) {
        return (color.length() == 3) ? color.concat(color) : color;
    }

    private Color hex2Rgb(String colorStr) {
        return Color.decode(colorStr);
    }

}
