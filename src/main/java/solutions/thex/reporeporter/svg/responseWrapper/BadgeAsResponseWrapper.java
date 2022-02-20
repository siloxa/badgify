package solutions.thex.reporeporter.svg.responseWrapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import solutions.thex.reporeporter.svg.SvgAsResponseWrapper;
import solutions.thex.reporeporter.svg.resolver.LTRBadgeResolver;
import solutions.thex.reporeporter.svg.resolver.RTLBadgeResolver;

import java.io.IOException;
import java.util.Map;

public class BadgeAsResponseWrapper implements SvgAsResponseWrapper {

    public ResponseEntity<String> wrap(Map<String, String> params) throws IOException {
        if ("-1".equals(params.get("title")) || "-1".equals(params.get("logo")))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(//
                "ltr".equals(params.get("direction")) ?//
                        new LTRBadgeResolver().resolve(params) ://
                        new RTLBadgeResolver().resolve(params)//
                , HttpStatus.OK);
    }

}
