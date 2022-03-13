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
                "link", "https://discordapp.com/users/" + link,//
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
                "link", "https://facebook.com/" + link,//
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
                "link", "https://github.com/" + link,//
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
                                         @RequestParam(value = "bg", required = false, defaultValue = "513a66")//
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
                "link", "https://gitlab.com/" + link,//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/gmail/{title}", produces = "image/svg+xml")
    public ResponseEntity<String> gmail(HttpServletRequest request,//
                                         @PathVariable(value = "title") String title,//
                                         @RequestParam(value = "theme", required = false, defaultValue = "simple")//
                                                 String theme,//
                                         @RequestParam(value = "size", required = false, defaultValue = "s")//
                                                 String size,//
                                         @RequestParam(value = "dir", required = false, defaultValue = "ltr")//
                                                 String direction,//
                                         @RequestParam(value = "link", required = false, defaultValue = "#")//
                                                 String link,//
                                         @RequestParam(value = "bg", required = false, defaultValue = "ca3f2e")//
                                                 String bg,//
                                         @RequestParam(value = "color", required = false, defaultValue = "rgb(255, 255, 255)")//
                                                 String color) throws Exception {
        logger.payloadLog("gmail", request, title, theme, size, direction, link, bg, color);

        return new LinkAsResponseWrapper().wrap(Map.of(//
                "title", title,//
                "icon", "gmail",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "mailto://" + link,//
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
                "link", "https://instagram.com/" + link,//
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
                "link", "https://www.linkedin.com/in/" + link,//
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
                "link", "https://pinterest.com/" + link,//
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
                "link", "https://pinterest.com/" + link,//
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
                "link", "https://www.reddit.com/user/" + link,//
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
                "link", "https://join.skype.com/invite/" + link,//
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
                "link", "https://open.spotify.com/user/" + link,//
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
                "icon", "stackoverflow",//
                "theme", theme,//
                "size", size,//
                "direction", direction,//
                "link", "https://stackoverflow.com/users/" + link,//
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
                "link", "https://steamcommunity.com/profiles/" + link,//
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
                "link", "https://t.me/" + link,//
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
                "link", "https://t.me/" + link,//
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
                "link", "https://twitter.com/" + link,//
                "bg", bg,//
                "color", color));
    }

    @GetMapping(path = "/yahoomail/{title}", produces = "image/svg+xml")
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
        logger.payloadLog("yahooMail", request, title, theme, size, direction, link, bg, color);

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
                "link", "https://youtube.com/" + link,//
                "bg", bg,//
                "color", color));
    }

}
