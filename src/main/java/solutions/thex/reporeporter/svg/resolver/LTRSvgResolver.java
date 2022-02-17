package solutions.thex.reporeporter.svg.resolver;

import solutions.thex.reporeporter.svg.SvgGenerator;
import solutions.thex.reporeporter.svg.SvgResolver;

import java.io.IOException;
import java.util.Map;

public class LTRSvgResolver extends SvgResolver {

    @Override
    public String resolve(Map<String, String> params) throws IOException {
        return SvgGenerator.builder()//
                .style(params.get("style"))//
                .theme(params.get("theme"))//
                .size(params.get("size"))//
                .direction("ltr")//
                .title(params.get("title"))//
                .logo(resolveLogo(params.get("logo"), params.get("color")))//
                .link(params.get("link"))//
                .textLength(resolveTextLength(params.get("title"), params.get("size")))
                .titleXPosition(resolveTitleXPosition(params.get("title"), params.get("size")))
                .width(resolveWidth(params.get("width"), params.get("size"), params.get("title")))//
                .height(resolveHeight(params.get("height"), params.get("size")))//
                .bg(params.get("bg"))//
                .color(colorResolver(params.get("color")))//
                .build().render();
    }

    private String resolveTitleXPosition(String title, String size) {
        return switch (size) {
            case "s" -> String.valueOf((int) Math.ceil((((title.length() * 6.4117647) / 2) + 24)) * 10);
            case "m" -> String.valueOf((int) Math.ceil((((title.length() * 7.05882353) / 2) + 27)) * 10);
            case "l" -> String.valueOf((int) Math.ceil((((title.length() * 8.2352941) / 2) + 34)) * 10);
            default -> "";
        };
    }

}
