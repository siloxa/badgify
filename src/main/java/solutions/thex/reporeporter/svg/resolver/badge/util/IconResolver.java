package solutions.thex.reporeporter.svg.resolver.badge.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.stream.Collectors;

public class IconResolver {

    protected static String retrieveIconFile(String icon) {
        return new BufferedReader(//
                new InputStreamReader(//
                        Objects.requireNonNull(//
                                Thread.currentThread().getContextClassLoader()//
                                        .getResourceAsStream("static/icons/" + icon.split("/")[0]//
                                                + "/" + icon.split("/")[1] + ".svg")),
                        StandardCharsets.UTF_8)).lines()//
                .collect(Collectors.joining("\n"));
    }

    protected static String fillColor(String color, String file) {
        String start = file.substring(0, file.indexOf("<path") + 6);
        String end = file.substring(file.indexOf("<path") + 5);
        color = "fill=\"" + ColorResolver.resolve(color) + "\"";
        return start + color + end;
    }

    protected static String replaceScapeChars(String file) {
        file = file.replaceAll("\"", "&quot;");
        file = file.replaceAll("'", "&apos;");
        file = file.replaceAll("<", "&lt;");
        file = file.replaceAll(">", "&gt;");
        file = file.replaceAll("&", "&amp;");
        return file;
    }

}
