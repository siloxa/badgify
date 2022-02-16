package solutions.thex.reporeporter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import solutions.thex.reporeporter.svg.SvgAsResponseResolver;

import javax.servlet.http.HttpServletRequest;

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
                                              @RequestParam(value = "direction",//
                                                      required = false,//
                                                      defaultValue = "ltr")//
                                                      String direction,//
                                              @RequestParam(value = "link",//
                                                      required = false,//
                                                      defaultValue = "#")//
                                                      String link,//
                                              @RequestParam(value = "width",//
                                                      required = false,//
                                                      defaultValue = "-1")//
                                                      String width,
                                              @RequestParam(value = "height",//
                                                      required = false,//
                                                      defaultValue = "-1")//
                                                      String height,//
                                              @RequestParam(value = "bg",//
                                                      required = false,//
                                                      defaultValue = "#e1e2e8")//
                                                      String bg,//
                                              @RequestParam(value = "color",//
                                                      required = false,//
                                                      defaultValue = "rgb(255, 255, 255)")//
                                                      String color) throws Exception {
        logger(request, title, logo, theme, size, direction, link, width, height, bg, color);

        return SvgAsResponseResolver.resolve(//
                "badge", title, logo, theme, size, direction, link, width, height, bg, color);
    }

    private void logger(HttpServletRequest request, String title, String logo, String theme, String size,//
                        String direction, String link, String width, String height, String bg, String color) {
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
    }

}
