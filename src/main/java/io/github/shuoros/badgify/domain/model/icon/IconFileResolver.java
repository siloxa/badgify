package io.github.shuoros.badgify.domain.model.icon;

import io.github.shuoros.badgify.domain.model.color.AbstractColor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;
import java.util.stream.Collectors;

public interface IconFileResolver {
    String DATA_IMAGE_SVG_XML_UTF_8 = "data:image/svg+xml;utf-8,";

    String DATA_IMAGE_SVG_XML_BASE_64 = "data:image/svg+xml;base64,";

    void resolve(AbstractColor color);

    default String retrieveIconFile(String iconName) {
        return new BufferedReader(
            new InputStreamReader(
                Objects.requireNonNull(
                    Thread
                        .currentThread()
                        .getContextClassLoader()
                        .getResourceAsStream("static/icons/" + iconName.split("/")[0] + "/" + iconName.split("/")[1] + ".svg")
                ),
                StandardCharsets.UTF_8
            )
        )
            .lines()
            .collect(Collectors.joining("\n"));
    }

    default String fillColor(String file, AbstractColor color) {
        final String start = file.substring(0, file.indexOf("<path") + 6);
        final String end = file.substring(file.indexOf("<path") + 5);
        final String colorInString = "fill=\"" + color.toString() + "\"";
        return start + colorInString + end;
    }

    default String replaceScapeChars(String file) {
        file = file.replaceAll("\"", "&quot;");
        file = file.replaceAll("'", "&apos;");
        file = file.replaceAll("<", "&lt;");
        file = file.replaceAll(">", "&gt;");
        file = file.replaceAll("&", "&amp;");
        return file;
    }

    default String encodeFromStringToBase64(String string) {
        return Base64.getEncoder().encodeToString(string.getBytes(StandardCharsets.UTF_8));
    }
}
