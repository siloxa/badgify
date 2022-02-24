package solutions.thex.reporeporter.controller.error;

import org.json.JSONObject;

import java.util.Date;

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