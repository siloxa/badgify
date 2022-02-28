package solutions.thex.reporeporter.svg.responseWrapper.badge.inline;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import solutions.thex.reporeporter.controller.error.ErrorAsBadge;
import solutions.thex.reporeporter.svg.InlineSvgAsResponseWrapper;
import solutions.thex.reporeporter.svg.resolver.badge.LTRLinkResolver;
import solutions.thex.reporeporter.svg.resolver.badge.RTLLinkResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InlineLinkAsResponseWrapper implements InlineSvgAsResponseWrapper {


    @Override
    public ResponseEntity<String> wrap(String design) throws IOException {
        if (isDesignValid(design)) {
            final Map<String, String> params =//
                    extractDesign(design);
            if (params.size() == 0) {
                return new ResponseEntity<>(//
                        new ErrorAsBadge(422, "Title or logo not provided!").toString(),//
                        HttpStatus.UNPROCESSABLE_ENTITY);
            }
            return new ResponseEntity<>(//
                    "ltr".equals(params.get("direction")) ?//
                            new LTRLinkResolver().resolve(params) ://
                            new RTLLinkResolver().resolve(params)//
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(//
                new ErrorAsBadge(422, "Design syntax error!").toString(),//
                HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public ResponseEntity<String> wrapShort(String design) throws IOException {
        if (isDesignValid(design)) {
            final Map<String, String> params =//
                    extractShortDesign(design);
            if (params.size() == 4) {
                return new ResponseEntity<>(//
                        new ErrorAsBadge(422, "Title or logo not provided!").toString(),//
                        HttpStatus.UNPROCESSABLE_ENTITY);
            }
            return new ResponseEntity<>(//
                    "ltr".equals(params.get("direction")) ?//
                            new LTRLinkResolver().resolve(params) ://
                            new RTLLinkResolver().resolve(params)//
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(//
                new ErrorAsBadge(422, "Design syntax error!").toString(),//
                HttpStatus.UNPROCESSABLE_ENTITY);
    }

    private Map<String, String> extractShortDesign(String design) {
        Map<String, String> params = new HashMap<>();
        String[] designParts = design.split("-");
        if (designParts.length == 4) {
            params.put("title", designParts[0]);
            params.put("logo", designParts[1]);
            params.put("bg", designParts[2]);
            params.put("color", designParts[3]);
        }
        params.put("direction", "ltr");
        params.put("size", "s");
        params.put("theme", "simple");
        params.put("link", "#");
        return params;
    }

    private Map<String, String> extractDesign(String design) {
        Map<String, String> params = new HashMap<>();
        String[] designParts = design.split("-");
        if (designParts.length == 8) {
            params.put("direction", designParts[0]);
            params.put("size", designParts[1]);
            params.put("theme", designParts[2]);
            params.put("title", designParts[3]);
            params.put("logo", designParts[4]);
            params.put("bg", designParts[5]);
            params.put("color", designParts[6]);
            params.put("link", designParts[7]);
        }
        return params;
    }

}
