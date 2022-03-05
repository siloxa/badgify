package solutions.thex.badgify.svg.resolver.badge.util.icon;

import solutions.thex.badgify.svg.resolver.badge.util.IconResolver;

public class IconscoutIconResolver extends IconResolver {

    public static String resolve(String icon){
        icon = icon.split("\\.")[0] + "/" + icon.split("\\.")[1] + ".svg";
        return "/icons/" + icon;
    }

}
