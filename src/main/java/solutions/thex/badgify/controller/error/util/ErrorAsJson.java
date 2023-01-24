package solutions.thex.badgify.controller.error.util;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * A default json template for error messages including http status code, timestamp, and message.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class ErrorAsJson {

    public String generate(int status, String error, String message, String path) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        json.put("error", error);
        json.put("message", message);
        json.put("path", path);
        json.put("timestamp", new Date().toString());
        return json.toString();
    }

}