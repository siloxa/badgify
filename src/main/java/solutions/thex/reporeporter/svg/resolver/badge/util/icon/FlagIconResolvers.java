package solutions.thex.reporeporter.svg.resolver.badge.util.icon;

import solutions.thex.reporeporter.svg.resolver.badge.util.IconResolver;

public class FlagIconResolvers extends IconResolver {

    public static String resolve(String icon){
        icon = icon.split("\\.")[0] + "s/" + icon.split("\\.")[1] + ".svg";
        return "/icons/" + icon;
    }

}
