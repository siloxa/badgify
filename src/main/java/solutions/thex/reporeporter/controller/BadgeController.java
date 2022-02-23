package solutions.thex.reporeporter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import solutions.thex.reporeporter.log.ControllerLogger;
import solutions.thex.reporeporter.svg.responseWrapper.badge.CustomBadgeAsResponseWrapper;
import solutions.thex.reporeporter.svg.responseWrapper.badge.LogoAsResponseWrapper;
import solutions.thex.reporeporter.svg.responseWrapper.badge.ProfileAsResponseWrapper;
import solutions.thex.reporeporter.svg.responseWrapper.badge.TitleAsResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@RestController
@RequestMapping("/api/badge")
public class BadgeController {

    private final ControllerLogger logger = new ControllerLogger(this.getClass());

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
     * @throws Exception If the badge could not be created.
     */
    @GetMapping(path = "/link", produces = "image/svg+xml")
    public ResponseEntity<String> linkBadge(HttpServletRequest request,//
                                            @RequestParam(value = "title", required = false, defaultValue = "-1")//
                                                    String title,
                                            @RequestParam(value = "logo", required = false, defaultValue = "-1")//
                                                    String logo,
                                            @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                    String theme,//
                                            @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                    String size,//
                                            @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                    String direction,//
                                            @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                    String link,//
                                            @RequestParam(value = "bg", required = false, defaultValue = "#e1e2e8")//
                                                    String bg,//
                                            @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                    String color) throws Exception {
        logger.payloadLog("linkBadge", request, title, logo, theme, size, direction, link, bg, color);

        return new CustomBadgeAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "logo", logo,//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", link,//
                "bg", bg,//
                "color", color));
    }

    /**
     * Creates logo badges.
     *
     * @param request The request.
     * @param logo    The logo of the badge.
     * @param theme   The theme of the badge.
     * @param size    The size of the badge.
     * @param link    The link of the badge.
     * @param bg      The background color of the badge.
     * @param color   The color of the badge.
     * @return The badge.
     * @throws Exception If the badge could not be created.
     */
    @GetMapping(path = "/logo", produces = "image/svg+xml")
    public ResponseEntity<String> logoBadge(HttpServletRequest request,//
                                            @RequestParam(value = "logo", required = false, defaultValue = "-1")//
                                                    String logo,
                                            @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                    String theme,//
                                            @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                    String size,//
                                            @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                    String link,//
                                            @RequestParam(value = "bg", required = false, defaultValue = "#e1e2e8")//
                                                    String bg,//
                                            @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                    String color) throws Exception {
        logger.payloadLog("logoBadge", request, logo, theme, size, link, bg, color);

        return new LogoAsResponseWrapper().wrap(Map.of(//
                "logo", logo,//
                "theme", theme,//
                "size", size,//
                "link", link,//
                "bg", bg,//
                "color", color));
    }

    /**
     * Creates title badges.
     *
     * @param request The request.
     * @param title   The title of the badge.
     * @param theme   The theme of the badge.
     * @param size    The size of the badge.
     * @param link    The link of the badge.
     * @param bg      The background color of the badge.
     * @param color   The color of the badge.
     * @return The badge.
     * @throws Exception If the badge could not be created.
     */
    @GetMapping(path = "/title", produces = "image/svg+xml")
    public ResponseEntity<String> titleBadge(HttpServletRequest request,//
                                             @RequestParam(value = "title", required = false, defaultValue = "-1")//
                                                     String title,
                                             @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                     String theme,//
                                             @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                     String size,//
                                             @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                     String link,//
                                             @RequestParam(value = "bg", required = false, defaultValue = "#e1e2e8")//
                                                     String bg,//
                                             @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                     String color) throws Exception {
        logger.payloadLog("titleBadge", request, title, theme, size, link, bg, color);

        return new TitleAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "theme", theme,//
                "size", size,//
                "link", link,//
                "bg", bg,//
                "color", color));
    }

    /**
     * Creates profile badges.
     *
     * @param request The request.
     * @param id      The id of GitHub profile.
     * @param theme   The theme of the badge.
     * @param color   The color of the badge.
     * @return The badge.
     * @throws Exception If the badge could not be created.
     */
    @GetMapping(path = "/profile", produces = "image/svg+xml")
    public ResponseEntity<String> profileBadge(HttpServletRequest request,//
                                               @RequestParam(value = "id", required = false, defaultValue = "-1")//
                                                       String id,
                                               @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                       String theme,//
                                               @RequestParam(value = "bg", required = false, defaultValue = "rgb(-1, -1, -1)")//
                                                       String bg,//
                                               @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                       String color) throws Exception {
        logger.payloadLog("profileBadge", request, id, theme, bg, color);

        return new ProfileAsResponseWrapper().wrap(Map.of(//
                "id", id,//
                "theme", theme,//
                "bg", bg,//
                "color", color));
    }

}
