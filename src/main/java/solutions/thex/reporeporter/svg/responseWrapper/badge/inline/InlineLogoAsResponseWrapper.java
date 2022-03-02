package solutions.thex.reporeporter.svg.responseWrapper.badge.inline;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import solutions.thex.reporeporter.controller.error.ErrorAsBadge;
import solutions.thex.reporeporter.svg.InlineSvgAsResponseWrapper;
import solutions.thex.reporeporter.svg.resolver.badge.LogoResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InlineLogoAsResponseWrapper extends InlineSvgAsResponseWrapper {

    @Override
    public ResponseEntity<String> wrap(String design) throws IOException {
        if (super.isDesignValid(design)) {
            final Map<String, String> params =//
                    extractDesign(design);
            if (params.size() == 0) {
                return new ResponseEntity<>(//
                        new ErrorAsBadge(422, "Logo not provided!").toString(),//
                        HttpStatus.UNPROCESSABLE_ENTITY);
            }
            return new ResponseEntity<>(//
                    new LogoResolver().resolve(params) //
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
            if (params.size() == 3) {
                return new ResponseEntity<>(//
                        new ErrorAsBadge(422, "Logo not provided!").toString(),//
                        HttpStatus.UNPROCESSABLE_ENTITY);
            }
            return new ResponseEntity<>(//
                    new LogoResolver().resolve(params) //
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
            params.put("logo", designParts[0]);
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
            params.put("logo", designParts[2]);
            params.put("bg", designParts[3]);
            params.put("color", designParts[4]);
            params.put("link", designParts[5]);
        }
        return params;
    }

}
