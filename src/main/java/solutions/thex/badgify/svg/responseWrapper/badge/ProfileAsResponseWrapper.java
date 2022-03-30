package solutions.thex.badgify.svg.responseWrapper.badge;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import solutions.thex.badgify.controller.error.util.ErrorAsBadge;
import solutions.thex.badgify.svg.SvgAsResponseWrapper;
import solutions.thex.badgify.svg.resolver.badge.ProfileResolver;

import java.io.IOException;
import java.util.Map;

/**
 * An implementation of {@link solutions.thex.badgify.svg.SvgAsResponseWrapper} which wrap up generated
 * profile badge SVG as a response.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class ProfileAsResponseWrapper implements SvgAsResponseWrapper {

    private final ProfileResolver profileResolver;
    private final ErrorAsBadge errorAsBadge;

    public ProfileAsResponseWrapper(ProfileResolver profileResolver, ErrorAsBadge errorAsBadge) {
        this.profileResolver = profileResolver;
        this.errorAsBadge = errorAsBadge;
    }

    @Override
    public ResponseEntity<String> wrap(Map<String, String> params) throws IOException {
        if ("-1".equals(params.get("id")))
            return new ResponseEntity<>(//
                    errorAsBadge.generate(422, "Title or icon not provided!"),//
                    HttpStatus.UNPROCESSABLE_ENTITY);

        return new ResponseEntity<>(//
                profileResolver.resolve(params) //
                , HttpStatus.OK);
    }

}
