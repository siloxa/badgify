package solutions.thex.badgify.svg.responseWrapper.badge.inline;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import solutions.thex.badgify.controller.error.ErrorAsBadge;
import solutions.thex.badgify.svg.InlineSvgAsResponseWrapper;
import solutions.thex.badgify.svg.resolver.badge.ProfileResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InlineProfileAsResponseWrapper extends InlineSvgAsResponseWrapper {

    @Override
    public ResponseEntity<String> wrap(String design) throws IOException {
        if (super.isDesignValid(design)) {
            final Map<String, String> params =//
                    extractDesign(design);
            if (params.size() == 0) {
                return new ResponseEntity<>(//
                        new ErrorAsBadge(422, "GitHub id not provided!").toString(),//
                        HttpStatus.UNPROCESSABLE_ENTITY);
            }
            return new ResponseEntity<>(//
                    new ProfileResolver().resolve(params) //
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(//
                new ErrorAsBadge(422, "Design syntax error!").toString(),//
                HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    public ResponseEntity<String> wrapShort(String design) throws IOException {
        if (super.isDesignValid(design)) {
            final Map<String, String> params =//
                    extractShortDesign(design);
            if (params.size() == 1) {
                return new ResponseEntity<>(//
                        new ErrorAsBadge(422, "GitHub id not provided!").toString(),//
                        HttpStatus.UNPROCESSABLE_ENTITY);
            }
            return new ResponseEntity<>(//
                    new ProfileResolver().resolve(params) //
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(//
                new ErrorAsBadge(422, "Design syntax error!").toString(),//
                HttpStatus.UNPROCESSABLE_ENTITY);
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
