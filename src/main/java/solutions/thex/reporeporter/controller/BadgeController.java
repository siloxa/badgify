package solutions.thex.reporeporter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import solutions.thex.reporeporter.svg.DesignParser;
import solutions.thex.reporeporter.svg.DesignResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/badge")
public class BadgeController {

    /**
     * Returns a badge for the given repository.
     *
     * ?design={first=repo%20reporter;second=$GITHUB$;direction=h;left=second;right=first;color=#fff;bg=#f48024;
     * theme=simple;link=https://github.com/TheXSolutions/repo-reporter}
     *
     * @param request The request.
     * @param design  The design.
     * @return The badge.
     */
    @GetMapping(path = "/", produces = "image/svg+xml")
    public ResponseEntity<String> customBadge(HttpServletRequest request,
                                              @RequestParam(value = "design", required = true, defaultValue = "-1")
                                                      String design) throws Exception {
        log.info("BadgeController.customBadge: " //
                + "payload: " + design//
                + "path= " + request.getRequestURI()//
                + ", ip= " + request.getRemoteAddr()//
                + ", user agent= " + request.getHeader("User-Agent"));

        if ("-1".equals(design))
            return new ResponseEntity<>("design can not be empty", HttpStatus.BAD_REQUEST);

        return DesignResolver.resolve(DesignParser.parse(design));
    }

}
