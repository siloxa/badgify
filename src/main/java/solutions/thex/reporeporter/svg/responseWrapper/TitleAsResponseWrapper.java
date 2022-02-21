package solutions.thex.reporeporter.svg.responseWrapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import solutions.thex.reporeporter.svg.SvgAsResponseWrapper;
import solutions.thex.reporeporter.svg.resolver.TitleResolver;

import java.io.IOException;
import java.util.Map;

public class TitleAsResponseWrapper implements SvgAsResponseWrapper {

    @Override
    public ResponseEntity<String> wrap(Map<String, String> params) throws IOException {
        if ("-1".equals(params.get("title")))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(//
                new TitleResolver().resolve(params) //
                , HttpStatus.OK);
    }

}
