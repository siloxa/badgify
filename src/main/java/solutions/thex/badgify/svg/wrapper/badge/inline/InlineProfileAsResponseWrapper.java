package solutions.thex.badgify.svg.wrapper.badge.inline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import solutions.thex.badgify.exception.NotSatisfiedParametersException;
import solutions.thex.badgify.svg.InlineSvgAsResponseWrapper;
import solutions.thex.badgify.svg.resolver.badge.ProfileResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of {@link solutions.thex.badgify.svg.InlineSvgAsResponseWrapper} which wrap up generated
 * inline profile badge SVG as a response.
 *
 * @author Soroush Shemshadi
 * @version 1.1.0
 * @since 1.1.0
 */
@Service
public class InlineProfileAsResponseWrapper extends InlineSvgAsResponseWrapper {

    private final ProfileResolver profileResolver;

    @Autowired
    public InlineProfileAsResponseWrapper(ProfileResolver profileResolver) {
        this.profileResolver = profileResolver;
    }

    @Override
    public ResponseEntity<String> wrap(String design) throws IOException {
        if (super.isDesignValid(design)) {
            final Map<String, String> params =//
                    extractDesign(design);
            if (params.size() == 0) throw new NotSatisfiedParametersException("GitHub user id parameter is required!");

            return new ResponseEntity<>(//
                    profileResolver.resolve(params) //
                    , HttpStatus.OK);
        }
        throw new NotSatisfiedParametersException("Design syntax error!");
    }

    @Override
    public ResponseEntity<String> wrapShort(String design) throws IOException {
        if (super.isDesignValid(design)) {
            final Map<String, String> params =//
                    extractShortDesign(design);
            if (params.size() == 1) throw new NotSatisfiedParametersException("GitHub user id parameter is required!");

            return new ResponseEntity<>(//
                    profileResolver.resolve(params) //
                    , HttpStatus.OK);
        }
        throw new NotSatisfiedParametersException("Design syntax error!");
    }

    private Map<String, String> extractShortDesign(String design) {
        Map<String, String> params = new HashMap<>();
        String[] designParts = design.split(super.splitter());
        if (designParts.length == 3) {
            params.put("id", designParts[0]);
            params.put("bg", designParts[1]);
            params.put("color", designParts[2]);
        }
        params.put("theme", "simple");
        return params;
    }

    private Map<String, String> extractDesign(String design) {
        Map<String, String> params = new HashMap<>();
        String[] designParts = design.split(super.splitter());
        if (designParts.length == 4) {
            params.put("theme", designParts[0]);
            params.put("id", designParts[1]);
            params.put("bg", designParts[2]);
            params.put("color", designParts[3]);
        }
        return params;
    }

}
