package solutions.thex.reporeporter.svg.resolver.badge;

import solutions.thex.reporeporter.svg.SvgResolver;
import solutions.thex.reporeporter.svg.generator.badge.TitleGenerator;

import java.io.IOException;
import java.util.Map;

/**
 * An implementation of {@link solutions.thex.reporeporter.svg.SvgResolver} which resolves given parameters by user to
 * a {@link solutions.thex.reporeporter.svg.resolver.badge.TitleResolver} instance.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
public class TitleResolver extends SvgResolver {

    @Override
    public String resolve(Map<String, String> params) throws IOException {
        final String bg = resolveBG(params.get("bg"));

        return TitleGenerator.builder()//
                .theme(params.get("theme"))//
                .size(params.get("size"))//
                .title(params.get("title"))//
                .link(params.get("link"))//
                .textLength(resolveTextLength(params.get("title"), params.get("size")))
                .titleXPosition(resolveTitleXPosition(params.get("title"), params.get("size")))
                .width(resolveWidth(params.get("size"), params.get("title")))//
                .height(resolveHeight(params.get("size")))//
                .bg(bg)//
                .color(resolveColor(params.get("color"), bg))//
                .build().render();
    }

    private String resolveTitleXPosition(String title, String size) {
        return switch (size) {
            case "s" -> String.valueOf((int) Math.ceil((((title.length() * 6.4117647) / 2) + 5)) * 10);
            case "m" -> String.valueOf((int) Math.ceil((((title.length() * 7.05882353) / 2) + 5)) * 10);
            case "l" -> String.valueOf((int) Math.ceil((((title.length() * 8.2352941) / 2) + 5)) * 10);
            default -> "";
        };
    }

    @Override
    protected String resolveWidth(String size, String title) {
        return switch (size) {
            case "s" -> String.valueOf((int) Math.ceil((title.length() * 6.4117647)) + 10);
            case "m" -> String.valueOf((int) Math.ceil((title.length() * 7.05882353)) + 10);
            case "l" -> String.valueOf((int) Math.ceil((title.length() * 8.2352941)) + 10);
            default -> "";
        };
    }

}
