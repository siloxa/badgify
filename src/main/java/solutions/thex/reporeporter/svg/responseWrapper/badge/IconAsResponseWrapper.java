package solutions.thex.reporeporter.svg.responseWrapper.badge;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import solutions.thex.reporeporter.controller.error.ErrorAsBadge;
import solutions.thex.reporeporter.svg.SvgAsResponseWrapper;
import solutions.thex.reporeporter.svg.resolver.badge.IconResolver;

import java.io.IOException;
import java.util.Map;

/**
 * An implementation of {@link solutions.thex.reporeporter.svg.SvgAsResponseWrapper} which wrap up generated
 * icon badge SVG as a response.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
public class IconAsResponseWrapper implements SvgAsResponseWrapper {

    @Override
    public ResponseEntity<String> wrap(Map<String, String> params) throws IOException {
        if ("-1".equals(params.get("icon")))
            return new ResponseEntity<>(//
                    new ErrorAsBadge(422, "Title or icon not provided!").toString(),//
                    HttpStatus.UNPROCESSABLE_ENTITY);

        return new ResponseEntity<>(//
                new IconResolver().resolve(params) //
                , HttpStatus.OK);
    }

}
