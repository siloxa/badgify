package solutions.thex.badgify.svg.resolver.badge.util.icon;

import solutions.thex.badgify.svg.resolver.badge.util.IconFileResolver;

public class FontAwesomeIconResolver extends IconFileResolver {

    public static String resolve(String icon, String color){
        String file = retrieveIconFile("font-awesome/" + icon);
        file = fillColor(color, file);
        file = replaceScapeChars(file);
        return "data:image/svg+xml;utf-8," + file;
    }

}
