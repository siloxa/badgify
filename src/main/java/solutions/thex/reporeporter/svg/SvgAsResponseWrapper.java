package solutions.thex.reporeporter.svg;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import solutions.thex.reporeporter.svg.resolver.LTRSvgResolver;
import solutions.thex.reporeporter.svg.resolver.RTLSvgResolver;

import java.io.IOException;
import java.util.Map;

public class SvgAsResponseWrapper {

    public static ResponseEntity<String> resolve(Map<String, String> params) throws IOException {
        if ("-1".equals(params.get("title")) || "-1".equals(params.get("logo")))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(//
                "ltr".equals(params.get("direction")) ?//
                        new LTRSvgResolver().resolve(params) ://
                        new RTLSvgResolver().resolve(params)//
                , HttpStatus.OK);
    }

}
