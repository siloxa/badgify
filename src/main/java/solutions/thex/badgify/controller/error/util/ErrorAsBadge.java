package solutions.thex.badgify.controller.error.util;

import org.springframework.stereotype.Component;
import solutions.thex.badgify.svg.resolver.badge.LTRLinkResolver;

import java.io.IOException;
import java.util.Map;

/**
 * Resolves an error badge template with the given error status and message.
 * It extends @{@link solutions.thex.badgify.svg.resolver.badge.LTRLinkResolver}.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class ErrorAsBadge extends LTRLinkResolver {

    public String generate(int status, String error) throws IOException {
        return resolve(Map.of(//
                "theme", "simple",//
                "size", "m",//
                "direction", "ltr",//
                "link", "#",//
                "title", status + ": " + error,//
                "icon", "triangle-exclamation",//
                "bg", "c4160a",//
                "color", "rgb(255, 255, 255)"));
    }

}
