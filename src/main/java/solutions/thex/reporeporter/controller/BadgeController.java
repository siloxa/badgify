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

@Slf4j
@RestController
@RequestMapping("/api/badge")
public class BadgeController {

    /**
     * Creates custom badges.
     *
     * Example: /?title=Repo%20Reporter&bg=f48024&link=https://repo-reporter.thex.solutions
     *
     * @param request The request.
     * @param title   The title of the badge.
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
                                              @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                      String theme,//
                                              @RequestParam(value = "size", required = false, defaultValue = "m")//
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
                .link(link)//
                .width(resolveWidth(width, size, title))//
                .height(resolveHeight(height, size))//
                .bg(bg)//
                .color(color)//
                .build().render();
        return new ResponseEntity<>(svg, HttpStatus.OK);
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
        if (size.equals("m")) {
            defaultWidth = String.valueOf((int) Math.ceil((title.length() * 6.4117647) + 29));
        }
        return defaultWidth;
    }

    private static String extractHeightDefaultValue(String size) {
        String defaultHeight = "";
        if (size.equals("m")) {
            defaultHeight = "24";
        }
        return defaultHeight;
    }

}
