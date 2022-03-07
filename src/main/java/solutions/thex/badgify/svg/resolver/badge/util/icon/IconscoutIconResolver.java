package solutions.thex.badgify.svg.resolver.badge.util.icon;

import solutions.thex.badgify.svg.resolver.badge.util.IconResolver;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class IconscoutIconResolver extends IconResolver {

    public static String resolve(String icon){
        icon = icon.split("\\.")[0] + "/" + icon.split("\\.")[1];
        String file = retrieveIconFile(icon);
        return "data:image/svg+xml;base64," + Base64.getEncoder().encodeToString(file.getBytes(StandardCharsets.UTF_8));
    }

}
