package solutions.thex.reporeporter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import solutions.thex.reporeporter.svg.SvgGenerator;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/badge")
public class BadgeController {

    /**
     * Creates custom badges.
     * <p>
     * Example: /?title=Repo%20Reporter&bg=f48024&link=https://repo-reporter.thex.solutions
     *
     * @param request The request.
     * @param title   The title of the badge.
     * @param logo    The logo of the badge.
     * @param link    The link of the badge.
     * @param bg      The background color of the badge.
     * @param size    The size of the badge.
     * @param width   The width of the badge.
     * @param height  The height of the badge.
     * @return The badge.
     */
    @GetMapping(path = "/", produces = "image/svg+xml")
    public ResponseEntity<String> customBadge(HttpServletRequest request,//
                                              @RequestParam(value = "title")//
                                                      String title,
                                              @RequestParam(value = "logo")//
                                                      String logo,
                                              @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                      String theme,//
                                              @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                      String size,//
                                              @RequestParam(value = "direction", required = false, defaultValue = "ltr")//
                                                      String direction,//
                                              @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                      String link,//
                                              @RequestParam(value = "width", required = false, defaultValue = "-1")//
                                                      String width,
                                              @RequestParam(value = "height", required = false, defaultValue = "-1")//
                                                      String height,//
                                              @RequestParam(value = "bg", required = false, defaultValue = "#e1e2e8")//
                                                      String bg,//
                                              @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                      String color) throws Exception {
        log.info("BadgeController.customBadge: " //
                + "payload: [" + theme//
                + ", " + size//
                + ", " + direction//
                + ", " + title//
                + ", " + logo//
                + ", " + link//
                + ",  " + width//
                + ", " + height//
                + ", " + bg//
                + ", " + color + "]"//
                + ", path= " + request.getRequestURI()//
                + ", ip= " + request.getRemoteAddr()//
                + ", user agent= " + request.getHeader("User-Agent"));

        String svg = SvgGenerator.builder()//
                .style("badge")//
                .theme(theme)//
                .size(size)//
                .direction(direction)//
                .title(title)//
                .logo(resolveLogo(logo, color))//
                .link(link)//
                .textLength(resolveTextLength(title))
                .titleXPosition(resolveTitleXPosition(title))
                .width(resolveWidth(width, size, title))//
                .height(resolveHeight(height, size))//
                .bg(bg)//
                .color(color)//
                .build().render();
        return new ResponseEntity<>(svg, HttpStatus.OK);
    }

    private String resolveTitleXPosition(String title) {
        return String.valueOf((int) Math.ceil((((title.length() * 6.4117647) / 2) + 24)) * 10);
    }

    private String resolveTextLength(String title) {
        return String.valueOf((int) Math.ceil(title.length() * 6.4117647) * 10);
    }

    private String resolveLogo(String logo, String color) {
        String file = retrieveLogoFile(logo);
        file = fillColor(color, file);
        file = replaceScapeChars(file);
        return file;
    }

    private String fillColor(String color, String file) {
        String start = file.substring(0, file.indexOf("<path") + 6);
        String end = file.substring(file.indexOf("<path") + 5);
        color = "fill=\"" + color + "\"";
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

    private String retrieveLogoFile(String logo) {
        return new BufferedReader(//
                new InputStreamReader(//
                        Objects.requireNonNull(//
                                Thread.currentThread().getContextClassLoader()//
                                        .getResourceAsStream("static/logos/" + logo + ".svg")),
                        StandardCharsets.UTF_8)).lines()//
                .collect(Collectors.joining("\n"));
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
        }
        return defaultWidth;
    }

    private static String extractHeightDefaultValue(String size) {
        String defaultHeight = "";
        if (size.equals("s")) {
            defaultHeight = "24";
        } else if (size.equals("m")) {
            defaultHeight = "29";
        }
        return defaultHeight;
    }

}
