package solutions.thex.badgify.controller.error;

import org.json.JSONObject;

import java.util.Date;

/**
 * A default json template for error messages including http status code, timestamp, and message.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
public class ErrorAsJson {

    JSONObject json = new JSONObject();

    public ErrorAsJson(int status, String error, String message, String path) {
        json.put("status", status);
        json.put("error", error);
        json.put("message", message);
        json.put("path", path);
        json.put("timestamp", new Date().toString());
    }


    public String toString() {
        return json.toString();
    }

}