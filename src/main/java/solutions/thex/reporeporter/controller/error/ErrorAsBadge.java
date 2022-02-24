package solutions.thex.reporeporter.controller.error;

import solutions.thex.reporeporter.svg.resolver.badge.LTRLinkResolver;

import java.io.IOException;
import java.util.Map;

public class ErrorAsBadge extends LTRLinkResolver {

    private final String svg;

    public ErrorAsBadge(int status, String error) throws IOException {
        this.svg = resolve(Map.of(//
                "theme", "simple",//
                "size", "m",//
                "direction", "ltr",//
                "link", "#",//
                "title", status + ": " + error,//
                "logo", "triangle-exclamation",//
                "bg", "c4160a",//
                "color", "rgb(255, 255, 255)"));
    }

    public String toString() {
        return svg;
    }

}
