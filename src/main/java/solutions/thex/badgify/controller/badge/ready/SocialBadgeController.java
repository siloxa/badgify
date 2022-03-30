package solutions.thex.badgify.controller.badge.ready;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solutions.thex.badgify.log.ControllerLogger;
import solutions.thex.badgify.svg.responseWrapper.badge.LinkAsResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/social")
public class SocialBadgeController {

    private final ControllerLogger logger = new ControllerLogger(this.getClass());

    @GetMapping(path = "/app-store/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> appStore(HttpServletRequest request,//
                                          @PathVariable(value = "title") String title,//
                                          @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                  String theme,//
                                          @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                  String size,//
                                          @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                  String direction,//
                                          @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                  String link,//
                                          @RequestParam(value = "bg", required = false, defaultValue = "1588b6")//
                                                  String bg,//
                                          @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                  String color) throws Exception {
        logger.payloadLog("app-store", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "app-store",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", link,//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/behance/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> behance(HttpServletRequest request,//
                                          @PathVariable(value = "title") String title,//
                                          @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                  String theme,//
                                          @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                  String size,//
                                          @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                  String direction,//
                                          @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                  String link,//
                                          @RequestParam(value = "bg", required = false, defaultValue = "004abf")//
                                                  String bg,//
                                          @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                  String color) throws Exception {
        logger.payloadLog("behance", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "behance",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://behance.net/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/discord/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> discord(HttpServletRequest request,//
                                          @PathVariable(value = "title") String title,//
                                          @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                  String theme,//
                                          @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                  String size,//
                                          @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                  String direction,//
                                          @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                  String link,//
                                          @RequestParam(value = "bg", required = false, defaultValue = "5253b8")//
                                                  String bg,//
                                          @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                  String color) throws Exception {
        logger.payloadLog("discord", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "discord",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://discordapp.com/users/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/dockerhub/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> dockerhub(HttpServletRequest request,//
                                          @PathVariable(value = "title") String title,//
                                          @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                  String theme,//
                                          @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                  String size,//
                                          @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                  String direction,//
                                          @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                  String link,//
                                          @RequestParam(value = "bg", required = false, defaultValue = "2486bb")//
                                                  String bg,//
                                          @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                  String color) throws Exception {
        logger.payloadLog("dockerhub", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "docker",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://hub.docker.com/u/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/dribbble/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> dribbble(HttpServletRequest request,//
                                          @PathVariable(value = "title") String title,//
                                          @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                  String theme,//
                                          @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                  String size,//
                                          @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                  String direction,//
                                          @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                  String link,//
                                          @RequestParam(value = "bg", required = false, defaultValue = "e53f6a")//
                                                  String bg,//
                                          @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                  String color) throws Exception {
        logger.payloadLog("dribbble", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "dribbble",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://dribbble.com/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/dropbox/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> dropbox(HttpServletRequest request,//
                                           @PathVariable(value = "title") String title,//
                                           @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                   String theme,//
                                           @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                   String size,//
                                           @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                   String direction,//
                                           @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                   String link,//
                                           @RequestParam(value = "bg", required = false, defaultValue = "0058c9")//
                                                   String bg,//
                                           @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                   String color) throws Exception {
        logger.payloadLog("dropbox", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "dropbox",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", link,//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/facebook/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> facebook(HttpServletRequest request,//
                                           @PathVariable(value = "title") String title,//
                                           @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                   String theme,//
                                           @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                   String size,//
                                           @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                   String direction,//
                                           @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                   String link,//
                                           @RequestParam(value = "bg", required = false, defaultValue = "374b76")//
                                                   String bg,//
                                           @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                   String color) throws Exception {
        logger.payloadLog("facebook", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "facebook",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://facebook.com/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/github/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> github(HttpServletRequest request,//
                                         @PathVariable(value = "title") String title,//
                                         @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                 String theme,//
                                         @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                 String size,//
                                         @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                 String direction,//
                                         @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                 String link,//
                                         @RequestParam(value = "bg", required = false, defaultValue = "222145")//
                                                 String bg,//
                                         @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                 String color) throws Exception {
        logger.payloadLog("github", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "github",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://github.com/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/gitlab/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> gitlab(HttpServletRequest request,//
                                         @PathVariable(value = "title") String title,//
                                         @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                 String theme,//
                                         @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                 String size,//
                                         @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                 String direction,//
                                         @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                 String link,//
                                         @RequestParam(value = "bg", required = false, defaultValue = "db3a20")//
                                                 String bg,//
                                         @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                 String color) throws Exception {
        logger.payloadLog("gitlab", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "gitlab",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://gitlab.com/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/goodreads/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> goodreads(HttpServletRequest request,//
                                            @PathVariable(value = "title") String title,//
                                            @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                    String theme,//
                                            @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                    String size,//
                                            @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                    String direction,//
                                            @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                    String link,//
                                            @RequestParam(value = "bg", required = false, defaultValue = "573925")//
                                                    String bg,//
                                            @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                    String color) throws Exception {
        logger.payloadLog("goodreads", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "goodreads",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://goodreads.com/user/show/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/google-drive/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> googleDrive(HttpServletRequest request,//
                                            @PathVariable(value = "title") String title,//
                                            @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                    String theme,//
                                            @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                    String size,//
                                            @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                    String direction,//
                                            @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                    String link,//
                                            @RequestParam(value = "bg", required = false, defaultValue = "ea3c2a")//
                                                    String bg,//
                                            @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                    String color) throws Exception {
        logger.payloadLog("google-drive", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "google-drive",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", link,//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/google-play/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> googlePlay(HttpServletRequest request,//
                                              @PathVariable(value = "title") String title,//
                                              @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                      String theme,//
                                              @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                      String size,//
                                              @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                      String direction,//
                                              @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                      String link,//
                                              @RequestParam(value = "bg", required = false, defaultValue = "ea3c2a")//
                                                      String bg,//
                                              @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                      String color) throws Exception {
        logger.payloadLog("google-play", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "google-play",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", link,//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/instagram/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> instagram(HttpServletRequest request,//
                                            @PathVariable(value = "title") String title,//
                                            @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                    String theme,//
                                            @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                    String size,//
                                            @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                    String direction,//
                                            @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                    String link,//
                                            @RequestParam(value = "bg", required = false, defaultValue = "ba0063")//
                                                    String bg,//
                                            @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                    String color) throws Exception {
        logger.payloadLog("instagram", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "instagram",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://instagram.com/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/kaggle/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> kaggle(HttpServletRequest request,//
                                              @PathVariable(value = "title") String title,//
                                              @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                      String theme,//
                                              @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                      String size,//
                                              @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                      String direction,//
                                              @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                      String link,//
                                              @RequestParam(value = "bg", required = false, defaultValue = "349ead")//
                                                      String bg,//
                                              @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                      String color) throws Exception {
        logger.payloadLog("kaggle", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "kaggle",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://www.kaggle.com/profile/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/kickstarter/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> kickstarter(HttpServletRequest request,//
                                            @PathVariable(value = "title") String title,//
                                            @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                    String theme,//
                                            @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                    String size,//
                                            @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                    String direction,//
                                            @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                    String link,//
                                            @RequestParam(value = "bg", required = false, defaultValue = "05b85f")//
                                                    String bg,//
                                            @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                    String color) throws Exception {
        logger.payloadLog("kickstarter", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "kickstarter",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://kickstarter.com/profile/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/linkedin/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> linkedin(HttpServletRequest request,//
                                           @PathVariable(value = "title") String title,//
                                           @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                   String theme,//
                                           @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                   String size,//
                                           @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                   String direction,//
                                           @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                   String link,//
                                           @RequestParam(value = "bg", required = false, defaultValue = "0072b1")//
                                                   String bg,//
                                           @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                   String color) throws Exception {
        logger.payloadLog("linkedin", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "linkedin",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://www.linkedin.com/in/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/medium/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> medium(HttpServletRequest request,//
                                         @PathVariable(value = "title") String title,//
                                         @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                 String theme,//
                                         @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                 String size,//
                                         @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                 String direction,//
                                         @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                 String link,//
                                         @RequestParam(value = "bg", required = false, defaultValue = "080706")//
                                                 String bg,//
                                         @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                 String color) throws Exception {
        logger.payloadLog("medium", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "medium",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://medium.com/@" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/paypal/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> paypal(HttpServletRequest request,//
                                            @PathVariable(value = "title") String title,//
                                            @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                    String theme,//
                                            @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                    String size,//
                                            @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                    String direction,//
                                            @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                    String link,//
                                            @RequestParam(value = "bg", required = false, defaultValue = "005387")//
                                                    String bg,//
                                            @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                    String color) throws Exception {
        logger.payloadLog("paypal", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "paypal",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://paypal.me/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/pinterest/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> pinterest(HttpServletRequest request,//
                                            @PathVariable(value = "title") String title,//
                                            @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                    String theme,//
                                            @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                    String size,//
                                            @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                    String direction,//
                                            @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                    String link,//
                                            @RequestParam(value = "bg", required = false, defaultValue = "da001a")//
                                                    String bg,//
                                            @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                    String color) throws Exception {
        logger.payloadLog("pinterest", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "pinterest",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://pinterest.com/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/quora/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> quora(HttpServletRequest request,//
                                        @PathVariable(value = "title") String title,//
                                        @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                String theme,//
                                        @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                String size,//
                                        @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                String direction,//
                                        @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                String link,//
                                        @RequestParam(value = "bg", required = false, defaultValue = "b0251d")//
                                                String bg,//
                                        @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                String color) throws Exception {
        logger.payloadLog("quora", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "quora",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://pinterest.com/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/reddit/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> reddit(HttpServletRequest request,//
                                         @PathVariable(value = "title") String title,//
                                         @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                 String theme,//
                                         @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                 String size,//
                                         @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                 String direction,//
                                         @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                 String link,//
                                         @RequestParam(value = "bg", required = false, defaultValue = "ff3e20")//
                                                 String bg,//
                                         @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                 String color) throws Exception {
        logger.payloadLog("reddit", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "reddit",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://www.reddit.com/user/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/skype/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> skype(HttpServletRequest request,//
                                        @PathVariable(value = "title") String title,//
                                        @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                String theme,//
                                        @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                String size,//
                                        @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                String direction,//
                                        @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                String link,//
                                        @RequestParam(value = "bg", required = false, defaultValue = "0094b4")//
                                                String bg,//
                                        @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                String color) throws Exception {
        logger.payloadLog("skype", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "skype",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://join.skype.com/invite/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/slack/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> slack(HttpServletRequest request,//
                                           @PathVariable(value = "title") String title,//
                                           @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                   String theme,//
                                           @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                   String size,//
                                           @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                   String direction,//
                                           @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                   String link,//
                                           @RequestParam(value = "bg", required = false, defaultValue = "4a133b")//
                                                   String bg,//
                                           @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                   String color) throws Exception {
        logger.payloadLog("slack", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "slack",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "http://" +(link.equals("#") ? title : link) + ".slack.com",//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/snapchat/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> snapchat(HttpServletRequest request,//
                                        @PathVariable(value = "title") String title,//
                                        @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                String theme,//
                                        @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                String size,//
                                        @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                String direction,//
                                        @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                String link,//
                                        @RequestParam(value = "bg", required = false, defaultValue = "f7da00")//
                                                String bg,//
                                        @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                String color) throws Exception {
        logger.payloadLog("snapchat", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "snapchat",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "http://www.snapchat.com/add/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/spotify/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> spotify(HttpServletRequest request,//
                                          @PathVariable(value = "title") String title,//
                                          @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                  String theme,//
                                          @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                  String size,//
                                          @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                  String direction,//
                                          @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                  String link,//
                                          @RequestParam(value = "bg", required = false, defaultValue = "1ed760")//
                                                  String bg,//
                                          @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                  String color) throws Exception {
        logger.payloadLog("spotify", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "spotify",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://open.spotify.com/user/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/stack-exchange/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> stackExchange(HttpServletRequest request,//
                                                @PathVariable(value = "title") String title,//
                                                @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                        String theme,//
                                                @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                        String size,//
                                                @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                        String direction,//
                                                @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                        String link,//
                                                @RequestParam(value = "bg", required = false, defaultValue = "123671")//
                                                        String bg,//
                                                @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                        String color) throws Exception {
        logger.payloadLog("stack-exchange", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "stack-exchange",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://meta.stackexchange.com/users/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/stackoverflow/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> stackoverflow(HttpServletRequest request,//
                                                @PathVariable(value = "title") String title,//
                                                @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                        String theme,//
                                                @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                        String size,//
                                                @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                        String direction,//
                                                @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                        String link,//
                                                @RequestParam(value = "bg", required = false, defaultValue = "f48024")//
                                                        String bg,//
                                                @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                        String color) throws Exception {
        logger.payloadLog("stackoverflow", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "stack-overflow",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://stackoverflow.com/users/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/steam/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> steam(HttpServletRequest request,//
                                        @PathVariable(value = "title") String title,//
                                        @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                String theme,//
                                        @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                String size,//
                                        @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                String direction,//
                                        @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                String link,//
                                        @RequestParam(value = "bg", required = false, defaultValue = "2a475e")//
                                                String bg,//
                                        @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                String color) throws Exception {
        logger.payloadLog("steam", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "steam",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://steamcommunity.com/profiles/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/telegram/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> telegram(HttpServletRequest request,//
                                           @PathVariable(value = "title") String title,//
                                           @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                   String theme,//
                                           @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                   String size,//
                                           @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                   String direction,//
                                           @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                   String link,//
                                           @RequestParam(value = "bg", required = false, defaultValue = "1c83b3")//
                                                   String bg,//
                                           @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                   String color) throws Exception {
        logger.payloadLog("telegram", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "telegram",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://t.me/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/tiktok/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> tiktok(HttpServletRequest request,//
                                           @PathVariable(value = "title") String title,//
                                           @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                   String theme,//
                                           @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                   String size,//
                                           @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                   String direction,//
                                           @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                   String link,//
                                           @RequestParam(value = "bg", required = false, defaultValue = "010101")//
                                                   String bg,//
                                           @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                   String color) throws Exception {
        logger.payloadLog("tiktok", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "tiktok",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://tiktok.com/@" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/tumblr/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> tumblr(HttpServletRequest request,//
                                         @PathVariable(value = "title") String title,//
                                         @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                 String theme,//
                                         @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                 String size,//
                                         @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                 String direction,//
                                         @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                 String link,//
                                         @RequestParam(value = "bg", required = false, defaultValue = "2f3942")//
                                                 String bg,//
                                         @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                 String color) throws Exception {
        logger.payloadLog("tumblr", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "tumblr",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://" + (link.equals("#") ? title : link) +".tumblr.com",//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/twitch/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> twitch(HttpServletRequest request,//
                                          @PathVariable(value = "title") String title,//
                                          @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                  String theme,//
                                          @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                  String size,//
                                          @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                  String direction,//
                                          @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                  String link,//
                                          @RequestParam(value = "bg", required = false, defaultValue = "913fc9")//
                                                  String bg,//
                                          @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                  String color) throws Exception {
        logger.payloadLog("twitch", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "twitch",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://twitch.tv/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/twitter/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> twitter(HttpServletRequest request,//
                                          @PathVariable(value = "title") String title,//
                                          @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                  String theme,//
                                          @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                  String size,//
                                          @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                  String direction,//
                                          @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                  String link,//
                                          @RequestParam(value = "bg", required = false, defaultValue = "1c89b5")//
                                                  String bg,//
                                          @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                  String color) throws Exception {
        logger.payloadLog("twitter", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "twitter",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://twitter.com/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/yahoo-mail/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> yahooMail(HttpServletRequest request,//
                                            @PathVariable(value = "title") String title,//
                                            @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                    String theme,//
                                            @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                    String size,//
                                            @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                    String direction,//
                                            @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                    String link,//
                                            @RequestParam(value = "bg", required = false, defaultValue = "672a75")//
                                                    String bg,//
                                            @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                    String color) throws Exception {
        logger.payloadLog("yahoo-mail", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "yahoo",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "mailto://" + link,//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/youtube/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> youtube(HttpServletRequest request,//
                                          @PathVariable(value = "title") String title,//
                                          @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                  String theme,//
                                          @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                  String size,//
                                          @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                  String direction,//
                                          @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                  String link,//
                                          @RequestParam(value = "bg", required = false, defaultValue = "f20000")//
                                                  String bg,//
                                          @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                  String color) throws Exception {
        logger.payloadLog("youtube", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "youtube",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://youtube.com/" + (link.equals("#") ? title : link),//
                "bg", bg,//
                "color", color));
    }

}
