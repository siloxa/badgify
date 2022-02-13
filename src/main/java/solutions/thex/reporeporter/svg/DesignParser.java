package solutions.thex.reporeporter.svg;

import java.util.Arrays;
import java.util.HashMap;

public class DesignParser {

    public static HashMap<String, String> parse(String design) {
        String[] elements = splitElements(design);
        return parseElements(elements);
    }

    private static String[] splitElements(String design) {
        return design.split(";");
    }

    private static HashMap<String, String> parseElements(String[] elements) {
        HashMap<String, String> parsedElement = new HashMap<>();
        Arrays.stream(elements).forEach(e ->{
            String key = e.split("=")[0];
            String value = e.split("=")[1];
            parsedElement.put(key, value);
        });
        return parsedElement;
    }

}
