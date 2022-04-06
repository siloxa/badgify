package solutions.thex.badgify.svg.responseWrapper.badge.inline;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import solutions.thex.badgify.exception.NotSatisfiedParametersException;
import solutions.thex.badgify.svg.InlineSvgAsResponseWrapper;
import solutions.thex.badgify.svg.resolver.badge.LTRLinkResolver;
import solutions.thex.badgify.svg.resolver.badge.RTLLinkResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of {@link InlineSvgAsResponseWrapper} which wrap up generated
 * inline link badge SVG as a response.
 *
 * @author Soroush Shemshadi
 * @version 1.2.0
 * @since 1.1.0
 */
@Service
public class InlineLinkAsResponseWrapper extends InlineSvgAsResponseWrapper {

    private final LTRLinkResolver ltrLinkResolver;
    private final RTLLinkResolver rtlLinkResolver;

    public InlineLinkAsResponseWrapper(LTRLinkResolver ltrLinkResolver,//
                                       RTLLinkResolver rtlLinkResolver) {
        this.ltrLinkResolver = ltrLinkResolver;
        this.rtlLinkResolver = rtlLinkResolver;
    }

    @Override
    public ResponseEntity<String> wrap(String design) throws IOException {
        if (super.isDesignValid(design)) {
            final Map<String, String> params =//
                    extractDesign(design);
            if (params.size() == 0)
                throw new NotSatisfiedParametersException("Title and Icon parameters are required!");

            return new ResponseEntity<>(//
                    "ltr".equals(params.get("direction")) ?//
                            ltrLinkResolver.resolve(params) ://
                            rtlLinkResolver.resolve(params)//
                    , HttpStatus.OK);
        }
        throw new NotSatisfiedParametersException("Design syntax error!");
    }

    @Override
    public ResponseEntity<String> wrapShort(String design) throws IOException {
        if (super.isDesignValid(design)) {
            final Map<String, String> params =//
                    extractShortDesign(design);
            if (params.size() == 4)
                throw new NotSatisfiedParametersException("Title and Icon parameters are required!");

            return new ResponseEntity<>(//
                    "ltr".equals(params.get("direction")) ?//
                            ltrLinkResolver.resolve(params) ://
                            rtlLinkResolver.resolve(params)//
                    , HttpStatus.OK);
        }
        throw new NotSatisfiedParametersException("Design syntax error!");
    }

    private Map<String, String> extractShortDesign(String design) {
        Map<String, String> params = new HashMap<>();
        String[] designParts = design.split(super.splitter());
        if (designParts.length == 4) {
            params.put("title", designParts[0]);
            params.put("icon", designParts[1]);
            params.put("bg", designParts[2]);
            params.put("size", designParts[3]);
        }
        params.put("direction", "ltr");
        params.put("color", "rgb(255, 255, 255)");
        params.put("theme", "simple");
        params.put("link", "#");
        return params;
    }

    private Map<String, String> extractDesign(String design) {
        Map<String, String> params = new HashMap<>();
        String[] designParts = design.split(super.splitter());
        if (designParts.length == 8) {
            params.put("direction", designParts[0]);
            params.put("size", designParts[1]);
            params.put("theme", designParts[2]);
            params.put("title", designParts[3]);
            params.put("icon", designParts[4]);
            params.put("bg", designParts[5]);
            params.put("color", designParts[6]);
            params.put("link", designParts[7]);
        }
        return params;
    }

}
