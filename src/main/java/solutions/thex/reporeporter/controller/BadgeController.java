package solutions.thex.reporeporter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import solutions.thex.reporeporter.svg.responseWrapper.BadgeAsResponseWrapper;
import solutions.thex.reporeporter.svg.responseWrapper.LogoAsResponseWrapper;
import solutions.thex.reporeporter.svg.responseWrapper.ProfileAsResponseWrapper;
import solutions.thex.reporeporter.svg.responseWrapper.TitleAsResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
     * @return The badge.
     */
    @GetMapping(path = "/", produces = "image/svg+xml")
    public ResponseEntity<String> customBadge(HttpServletRequest request,//
                                              @RequestParam(value = "title",//
                                                      required = false,//
                                                      defaultValue = "-1")//
                                                      String title,
                                              @RequestParam(value = "logo",
                                                      required = false,//
                                                      defaultValue = "-1")//
                                                      String logo,
                                              @RequestParam(value = "theme",//
                                                      required = false,//
                                                      defaultValue = "simple")//
                                                      String theme,//
                                              @RequestParam(value = "size",//
                                                      required = false,//
                                                      defaultValue = "s")//
                                                      String size,//
                                              @RequestParam(value = "dir",//
                                                      required = false,//
                                                      defaultValue = "ltr")//
                                                      String direction,//
                                              @RequestParam(value = "link",//
                                                      required = false,//
                                                      defaultValue = "#")//
                                                      String link,//
                                              @RequestParam(value = "bg",//
                                                      required = false,//
                                                      defaultValue = "#e1e2e8")//
                                                      String bg,//
                                              @RequestParam(value = "color",//
                                                      required = false,//
                                                      defaultValue = "rgb(255, 255, 255)")//
                                                      String color) throws Exception {
        logger(request, title, logo, theme, size, direction, link, bg, color);

        return new BadgeAsResponseWrapper().wrap(//
                paramsToMap("badge", title, logo, theme, size, direction, link, bg, color));
    }

    @GetMapping(path = "/logo", produces = "image/svg+xml")
    public ResponseEntity<String> logoBadge(HttpServletRequest request,//
                                            @RequestParam(value = "logo",
                                                    required = false,//
                                                    defaultValue = "-1")//
                                                    String logo,
                                            @RequestParam(value = "theme",//
                                                    required = false,//
                                                    defaultValue = "simple")//
                                                    String theme,//
                                            @RequestParam(value = "size",//
                                                    required = false,//
                                                    defaultValue = "s")//
                                                    String size,//
                                            @RequestParam(value = "link",//
                                                    required = false,//
                                                    defaultValue = "#")//
                                                    String link,//
                                            @RequestParam(value = "bg",//
                                                    required = false,//
                                                    defaultValue = "#e1e2e8")//
                                                    String bg,//
                                            @RequestParam(value = "color",//
                                                    required = false,//
                                                    defaultValue = "rgb(255, 255, 255)")//
                                                    String color) throws Exception {
        logger(request, "-1", logo, theme, size, "-1", link, bg, color);

        return new LogoAsResponseWrapper().wrap(//
                paramsToMap("logo", "-1", logo, theme, size, "-1", link, bg, color));
    }

    @GetMapping(path = "/title", produces = "image/svg+xml")
    public ResponseEntity<String> titleBadge(HttpServletRequest request,//
                                             @RequestParam(value = "title",//
                                                     required = false,//
                                                     defaultValue = "-1")//
                                                     String title,
                                             @RequestParam(value = "theme",//
                                                     required = false,//
                                                     defaultValue = "simple")//
                                                     String theme,//
                                             @RequestParam(value = "size",//
                                                     required = false,//
                                                     defaultValue = "s")//
                                                     String size,//
                                             @RequestParam(value = "link",//
                                                     required = false,//
                                                     defaultValue = "#")//
                                                     String link,//
                                             @RequestParam(value = "bg",//
                                                     required = false,//
                                                     defaultValue = "#e1e2e8")//
                                                     String bg,//
                                             @RequestParam(value = "color",//
                                                     required = false,//
                                                     defaultValue = "rgb(255, 255, 255)")//
                                                     String color) throws Exception {
        logger(request, title, "-1", theme, size, "-1", link, bg, color);

        return new TitleAsResponseWrapper().wrap(//
                paramsToMap("title", title, "-1", theme, size, "-1", link, bg, color));
    }

    @GetMapping(path = "/profile", produces = "image/svg+xml")
    public ResponseEntity<String> profileBadge(HttpServletRequest request,//
                                               @RequestParam(value = "id",//
                                                       required = false,//
                                                       defaultValue = "-1")//
                                                       String id,
                                               @RequestParam(value = "theme",//
                                                       required = false,//
                                                       defaultValue = "simple")//
                                                       String theme,//
                                               @RequestParam(value = "color",//
                                                       required = false,//
                                                       defaultValue = "rgb(255, 255, 255)")//
                                                       String color) throws Exception {
        //logger(request, title, "-1", theme, size, "-1", link, bg, color);

        return new ProfileAsResponseWrapper().wrap(//
                paramsToMap("profile", id, "-1", theme, "-1", "-1", "-1", "-1", color));
    }

    private void logger(HttpServletRequest request, String title, String logo, String theme, String size,//
                        String direction, String link, String bg, String color) {
        log.info("BadgeController.customBadge: " //
                + "payload: [" + theme//
                + ", " + size//
                + ", " + direction//
                + ", " + title//
                + ", " + logo//
                + ", " + link//
                + ", " + bg//
                + ", " + color + "]"//
                + ", path= " + request.getRequestURI()//
                + ", ip= " + request.getRemoteAddr()//
                + ", user agent= " + request.getHeader("User-Agent"));
    }

    private Map<String, String> paramsToMap(String style, String title, String logo, String theme, String size,//
                                            String direction, String link, String bg, String color) {
        return Map.ofEntries(Map.entry("style", style),//
                Map.entry("title", title),//
                Map.entry("logo", logo),//
                Map.entry("theme", theme),//
                Map.entry("size", size),//
                Map.entry("direction", direction),//
                Map.entry("link", link),//
                Map.entry("width", "-1"),//
                Map.entry("height", "-1"),//
                Map.entry("bg", bg),//
                Map.entry("color", color));
    }

}
