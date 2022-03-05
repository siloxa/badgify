package solutions.thex.reporeporter.svg.responseWrapper.badge;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import solutions.thex.reporeporter.controller.error.ErrorAsBadge;
import solutions.thex.reporeporter.svg.SvgAsResponseWrapper;
import solutions.thex.reporeporter.svg.resolver.badge.ProfileResolver;

import java.io.IOException;
import java.util.Map;

/**
 * An implementation of {@link solutions.thex.reporeporter.svg.SvgAsResponseWrapper} which wrap up generated
 * profile badge SVG as a response.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
public class ProfileAsResponseWrapper implements SvgAsResponseWrapper {
    @Override
    public ResponseEntity<String> wrap(Map<String, String> params) throws IOException {
        if ("-1".equals(params.get("id")))
            return new ResponseEntity<>(//
                    new ErrorAsBadge(422, "Title or icon not provided!").toString(),//
                    HttpStatus.UNPROCESSABLE_ENTITY);

        return new ResponseEntity<>(//
                new ProfileResolver().resolve(params) //
                , HttpStatus.OK);
    }
}
