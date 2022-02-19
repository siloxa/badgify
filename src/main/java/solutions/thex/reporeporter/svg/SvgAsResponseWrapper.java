package solutions.thex.reporeporter.svg;

import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Map;

public interface SvgAsResponseWrapper {

    ResponseEntity<String> wrap(Map<String, String> params) throws IOException;

}
