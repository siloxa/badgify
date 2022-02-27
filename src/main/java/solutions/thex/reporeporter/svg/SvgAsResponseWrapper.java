package solutions.thex.reporeporter.svg;

import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Map;

/**
 * Wraps the generated svg as a response entity. For example see
 * {@link solutions.thex.reporeporter.svg.responseWrapper.badge.LinkAsResponseWrapper}.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
public interface SvgAsResponseWrapper {

    ResponseEntity<String> wrap(Map<String, String> params) throws IOException;

}
