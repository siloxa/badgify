package solutions.thex.badgify.svg.wrapper.badge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import solutions.thex.badgify.exception.NotSatisfiedParametersException;
import solutions.thex.badgify.svg.SvgAsResponseWrapper;
import solutions.thex.badgify.svg.resolver.badge.IconResolver;

import java.io.IOException;
import java.util.Map;

/**
 * An implementation of {@link solutions.thex.badgify.svg.SvgAsResponseWrapper} which wrap up generated
 * icon badge SVG as a response.
 *
 * @author Soroush Shemshadi
 * @version 1.2.0
 * @since 1.0.0
 */
@Service
public class IconAsResponseWrapper implements SvgAsResponseWrapper {

    private final IconResolver iconResolver;

    @Autowired
    public IconAsResponseWrapper(IconResolver iconResolver) {
        this.iconResolver = iconResolver;
    }

    @Override
    public ResponseEntity<String> wrap(Map<String, String> params) throws IOException, NotSatisfiedParametersException {
        if ("-1".equals(params.get("icon"))) throw new NotSatisfiedParametersException("Icon parameter is required!");

        return new ResponseEntity<>(//
                iconResolver.resolve(params) //
                , HttpStatus.OK);
    }

}
