package solutions.thex.reporeporter.svg;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.stream.Collectors;

public class SvgAsResponseResolver {

    public static ResponseEntity<String> resolve(String style, String title, String logo, String theme, String size,//
                                                 String direction, String link, String width, String height,//
                                                 String bg, String color) throws IOException {
        if ("-1".equals(title) || "-1".equals(logo))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(SvgGenerator.builder()//
                .style(style)//
                .theme(theme)//
                .size(size)//
                .direction(direction)//
                .title(title)//
                .logo(resolveLogo(logo, color))//
                .link(link)//
                .textLength(resolveTextLength(title, size))
                .titleXPosition(resolveTitleXPosition(title, size))
                .width(resolveWidth(width, size, title))//
                .height(resolveHeight(height, size))//
                .bg(bg)//
                .color(colorResolver(color))//
                .build().render(), HttpStatus.OK);
    }

    private static String resolveLogo(String logo, String color) {
        String file = retrieveLogoFile(logo);
        file = fillColor(color, file);
        file = replaceScapeChars(file);
        return file;
    }

    private static String retrieveLogoFile(String logo) {
        return new BufferedReader(//
                new InputStreamReader(//
                        Objects.requireNonNull(//
                                Thread.currentThread().getContextClassLoader()//
                                        .getResourceAsStream("static/logos/" + logo + ".svg")),
                        StandardCharsets.UTF_8)).lines()//
                .collect(Collectors.joining("\n"));
    }

    private static String fillColor(String color, String file) {
        String start = file.substring(0, file.indexOf("<path") + 6);
        String end = file.substring(file.indexOf("<path") + 5);
        color = "fill=\"" + colorResolver(color) + "\"";
        return start + color + end;
    }

    private static String replaceScapeChars(String file) {
        file = file.replaceAll("\"", "&quot;");
        file = file.replaceAll("'", "&apos;");
        file = file.replaceAll("<", "&lt;");
        file = file.replaceAll(">", "&gt;");
        file = file.replaceAll("&", "&amp;");
        return file;
    }

    private static String resolveTextLength(String title, String size) {
        String textLength = "";
        if (size.equals("s")) {
            textLength = String.valueOf((int) Math.ceil(title.length() * 6.4117647) * 10);
        } else if (size.equals("m")) {
            textLength = String.valueOf((int) Math.ceil(title.length() * 7.05882353) * 10);
        } else if (size.equals("l")) {
            textLength = String.valueOf((int) Math.ceil(title.length() * 8.2352941) * 10);
        }
        return textLength;
    }

    private static String resolveTitleXPosition(String title, String size) {
        String xPosition = "";
        if (size.equals("s")) {
            xPosition = String.valueOf((int) Math.ceil((((title.length() * 6.4117647) / 2) + 24)) * 10);
        } else if (size.equals("m")) {
            xPosition = String.valueOf((int) Math.ceil((((title.length() * 7.05882353) / 2) + 27)) * 10);
        } else if (size.equals("l")) {
            xPosition = String.valueOf((int) Math.ceil((((title.length() * 8.2352941) / 2) + 34)) * 10);
        }
        return xPosition;
    }

    private static String resolveWidth(String width, String size, String title) {
        if ("-1".equals(width))
            return extractWidthDefaultValue(size, title);
        return width;
    }

    private static String resolveHeight(String height, String size) {
        if ("-1".equals(height))
            return extractHeightDefaultValue(size);
        return height;
    }

    private static String extractWidthDefaultValue(String size, String title) {
        String defaultWidth = "";
        if (size.equals("s")) {
            defaultWidth = String.valueOf((int) Math.ceil((title.length() * 6.4117647) + 29));
        } else if (size.equals("m")) {
            defaultWidth = String.valueOf((int) Math.ceil((title.length() * 7.05882353) + 33));
        } else if (size.equals("l")) {
            defaultWidth = String.valueOf((int) Math.ceil((title.length() * 8.2352941) + 40));
        }
        return defaultWidth;
    }

    private static String extractHeightDefaultValue(String size) {
        String defaultHeight = "";
        if (size.equals("s")) {
            defaultHeight = "24";
        } else if (size.equals("m")) {
            defaultHeight = "29";
        } else if (size.equals("l")) {
            defaultHeight = "35";
        }
        return defaultHeight;
    }

    private static String colorResolver(String color) {
        if ("#".concat(color).matches("^#(?:[0-9a-fA-F]{3}){1,2}$")) {
            Color rgb = hex2Rgb("#".concat(standardize3HexTo6Hex(color)));
            return rgbStringBuilder(rgb);
        }
        return color;
    }

    private static String rgbStringBuilder(Color rgb) {
        return "rgb(" + rgb.getRed() + "," + rgb.getGreen() + "," + rgb.getBlue() + ")";
    }

    private static String standardize3HexTo6Hex(String color) {
        return (color.length() == 3) ? color.concat(color) : color;
    }

    private static Color hex2Rgb(String colorStr) {
        return Color.decode(colorStr);
    }

}
