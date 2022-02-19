package solutions.thex.reporeporter.svg.resolver;

import solutions.thex.reporeporter.svg.SvgGenerator;
import solutions.thex.reporeporter.svg.SvgResolver;

import java.io.IOException;
import java.util.Map;

public class LogoResolver extends SvgResolver {

    @Override
    public String resolve(Map<String, String> params) throws IOException {
        return SvgGenerator.builder()//
                .style(params.get("style"))//
                .theme(params.get("theme"))//
                .size(params.get("size"))//
                .title(params.get("logo"))//
                .logo(resolveLogo(params.get("logo"), params.get("color")))//
                .link(params.get("link"))//
                .width(resolveWidth(params.get("width"), params.get("size"), params.get("title")))//
                .height(resolveHeight(params.get("height"), params.get("size")))//
                .bg(params.get("bg"))//
                .color(colorResolver(params.get("color")))//
                .build().render();
    }

    @Override
    protected String resolveWidth(String width, String size, String title) {
        return switch (size) {
            case "s" -> "24";
            case "m" -> "29";
            case "l" -> "35";
            default -> "";
        };
    }

}
