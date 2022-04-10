package solutions.thex.badgify.svg.wrapper.badge.inline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import solutions.thex.badgify.exception.NotSatisfiedParametersException;
import solutions.thex.badgify.svg.InlineSvgAsResponseWrapper;
import solutions.thex.badgify.svg.resolver.badge.IconResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of {@link solutions.thex.badgify.svg.InlineSvgAsResponseWrapper} which wrap up generated
 * inline icon badge SVG as a response.
 *
 * @author Soroush Shemshadi
 * @version 1.2.0
 * @since 1.1.0
 */
@Service
public class InlineIconAsResponseWrapper extends InlineSvgAsResponseWrapper {

    private final IconResolver iconResolver;

    @Autowired
    public InlineIconAsResponseWrapper(IconResolver iconResolver) {
        this.iconResolver = iconResolver;
    }

    @Override
    public ResponseEntity<String> wrap(String design) throws IOException {
        if (super.isDesignValid(design)) {
            final Map<String, String> params =//
                    extractDesign(design);
            if (params.size() == 0) throw new NotSatisfiedParametersException("Icon parameter is required!");

            return new ResponseEntity<>(//
                    iconResolver.resolve(params) //
                    , HttpStatus.OK);
        }
        throw new NotSatisfiedParametersException("Design syntax error!");
    }

    @Override
    public ResponseEntity<String> wrapShort(String design) throws IOException {
        if (super.isDesignValid(design)) {
            final Map<String, String> params =//
                    extractShortDesign(design);
            if (params.size() == 3) throw new NotSatisfiedParametersException("Icon parameter is required!");

            return new ResponseEntity<>(//
                    iconResolver.resolve(params) //
                    , HttpStatus.OK);
        }
        throw new NotSatisfiedParametersException("Design syntax error!");
    }

    private Map<String, String> extractShortDesign(String design) {
        Map<String, String> params = new HashMap<>();
        String[] designParts = design.split(super.splitter());
        if (designParts.length == 3) {
            params.put("icon", designParts[0]);
            params.put("bg", designParts[1]);
            params.put("size", designParts[2]);
        }
        params.put("color", "rgb(255, 255, 255)");
        params.put("theme", "simple");
        params.put("link", "#");
        return params;
    }

    private Map<String, String> extractDesign(String design) {
        Map<String, String> params = new HashMap<>();
        String[] designParts = design.split(super.splitter());
        if (designParts.length == 6) {
            params.put("size", designParts[0]);
            params.put("theme", designParts[1]);
            params.put("icon", designParts[2]);
            params.put("bg", designParts[3]);
            params.put("color", designParts[4]);
            params.put("link", designParts[5]);
        }
        return params;
    }

}
