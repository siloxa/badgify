package solutions.thex.reporeporter.controller.badge;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import solutions.thex.reporeporter.log.ControllerLogger;
import solutions.thex.reporeporter.svg.responseWrapper.badge.LinkAsResponseWrapper;
import solutions.thex.reporeporter.svg.responseWrapper.badge.IconAsResponseWrapper;
import solutions.thex.reporeporter.svg.responseWrapper.badge.ProfileAsResponseWrapper;
import solutions.thex.reporeporter.svg.responseWrapper.badge.TitleAsResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Controller for the badge requests.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/badge")
public class BadgeController {

    private final ControllerLogger logger = new ControllerLogger(this.getClass());

    /**
     * Creates custom badges.
     *
     * Example: /link?title=repo-reporter&icon=github&theme=simple&size=s&dir=ltr&bg=f48024&color=fff
     * &link=https://repo-reporter.thex.solutions
     *
     * @param request The request.
     * @param title   The title of the badge.
     * @param icon    The icon of the badge.
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
                                            @RequestParam(value = "icon", required = false, defaultValue = "-1")//
                                                    String icon,
                                            @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                    String theme,//
                                            @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                    String size,//
                                            @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                    String direction,//
                                            @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                    String link,//
                                            @RequestParam(value = "bg", required = false, defaultValue = "000")//
                                                    String bg,//
                                            @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                    String color) throws Exception {
        logger.payloadLog("linkBadge", request, title, icon, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", icon,//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", link,//
                "bg", bg,//
                "color", color));
    }

    /**
     * Creates icon badges.
     *
     * Example: /icon?icon=github&theme=simple&size=s&bg=f48024&color=fff&link=https://repo-reporter.thex.solutions
     *
     * @param request The request.
     * @param icon    The icon of the badge.
     * @param theme   The theme of the badge.
     * @param size    The size of the badge.
     * @param link    The link of the badge.
     * @param bg      The background color of the badge.
     * @param color   The color of the badge.
     * @return The badge.
     * @throws Exception If the badge could not be created.
     */
    @GetMapping(path = "/icon", produces = "image/svg+xml")
    public ResponseEntity<String> iconBadge(HttpServletRequest request,//
                                            @RequestParam(value = "icon", required = false, defaultValue = "-1")//
                                                    String icon,
                                            @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                    String theme,//
                                            @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                    String size,//
                                            @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                    String link,//
                                            @RequestParam(value = "bg", required = false, defaultValue = "000")//
                                                    String bg,//
                                            @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                    String color) throws Exception {
        logger.payloadLog("iconBadge", request, icon, theme, size, link, bg, color);

        return new IconAsResponseWrapper().wrap(Map.of(//
                "icon", icon,//
                "theme", theme,//
                "size", size,//
                "link", link,//
                "bg", bg,//
                "color", color));
    }

    /**
     * Creates title badges.
     *
     * Example: /title?title=repo-reporter&theme=simple&size=s&bg=f48024&color=fff
     * &link=https://repo-reporter.thex.solutions
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
                                             @RequestParam(value = "bg", required = false, defaultValue = "000")//
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
     * Example: /profile?id=TheXSolutions&theme=simple&size=s&bg=f48024&color=fff
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
