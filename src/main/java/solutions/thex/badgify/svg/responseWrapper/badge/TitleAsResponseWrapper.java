package solutions.thex.badgify.svg.responseWrapper.badge;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import solutions.thex.badgify.exception.NotSatisfiedParametersException;
import solutions.thex.badgify.svg.SvgAsResponseWrapper;
import solutions.thex.badgify.svg.resolver.badge.TitleResolver;

import java.io.IOException;
import java.util.Map;

/**
 * An implementation of {@link solutions.thex.badgify.svg.SvgAsResponseWrapper} which wrap up generated
 * title badge SVG as a response.
 *
 * @author Soroush Shemshadi
 * @version 1.1.0
 * @since 1.0.0
 */
@Service
public class TitleAsResponseWrapper implements SvgAsResponseWrapper {

    private final TitleResolver titleResolver;

    public TitleAsResponseWrapper(TitleResolver titleResolver) {
        this.titleResolver = titleResolver;
    }

    @Override
    public ResponseEntity<String> wrap(Map<String, String> params) throws IOException {
        if ("-1".equals(params.get("title"))) throw new NotSatisfiedParametersException("Title parameter is required!");

        return new ResponseEntity<>(//
                titleResolver.resolve(params) //
                , HttpStatus.OK);
    }

}
