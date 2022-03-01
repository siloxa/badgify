package solutions.thex.reporeporter.svg;

import org.springframework.http.ResponseEntity;
import solutions.thex.reporeporter.util.Regex;

import java.io.IOException;

public interface InlineSvgAsResponseWrapper {

    ResponseEntity<String> wrap(String design) throws IOException;

    ResponseEntity<String> wrapShort(String design) throws IOException;

    default Boolean isDesignValid(String design) {
        return Regex.builder()//
                .pattern("[a-zA-Z0-9+#+%]\\w*")//
                .build().matches(design);
    }

}
