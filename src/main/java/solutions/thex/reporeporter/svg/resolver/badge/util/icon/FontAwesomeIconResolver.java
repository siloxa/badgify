package solutions.thex.reporeporter.svg.resolver.badge.util.icon;

import solutions.thex.reporeporter.svg.resolver.badge.util.IconResolver;

public class FontAwesomeIconResolver extends IconResolver {

    public static String resolve(String icon, String color){
        String file = retrieveIconFile("font-awesome/" + icon);
        file = fillColor(color, file);
        file = replaceScapeChars(file);
        return "data:image/svg+xml;utf-8," + file;
    }
}
