package solutions.thex.reporeporter.svg.responseWrapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import solutions.thex.reporeporter.svg.SvgAsResponseWrapper;
import solutions.thex.reporeporter.svg.resolver.LogoResolver;

import java.io.IOException;
import java.util.Map;

public class LogoAsResponseWrapper implements SvgAsResponseWrapper {

    @Override
    public ResponseEntity<String> wrap(Map<String, String> params) throws IOException {
        if ("-1".equals(params.get("logo")))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(//
                new LogoResolver().resolve(params) //
                , HttpStatus.OK);
    }

}
