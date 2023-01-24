package solutions.thex.badgify.svg;

import org.springframework.http.ResponseEntity;
import solutions.thex.badgify.svg.wrapper.badge.inline.InlineLinkAsResponseWrapper;
import solutions.thex.badgify.util.Regex;

import java.io.IOException;

/**
 * Wraps the generated svg as a response entity for inline requests. For example see
 * {@link InlineLinkAsResponseWrapper}.
 *
 * @author Soroush Shemshadi
 * @version 1.1.0
 * @since 1.1.0
 */
public abstract class InlineSvgAsResponseWrapper {

    abstract public ResponseEntity<String> wrap(String design) throws IOException;

    abstract public ResponseEntity<String> wrapShort(String design) throws IOException;

    private String splitter;

    public String splitter() {
        return this.splitter;
    }

    public Boolean isDesignValid(String design) {
        if (Regex.builder()//
                .pattern("[^ ]+")//
                .build().matches(design).count() > 2) {
            splitter = " ";
            return true;
        } else if (Regex.builder()//
                .pattern("[^_]+")//
                .build().matches(design).count() > 2) {
            splitter = "_";
            return true;
        } else if (Regex.builder()//
                .pattern("[^-]+")//
                .build().matches(design).count() > 2) {
            splitter = "-";
            return true;
        }
        return false;
    }

}
