package solutions.thex.badgify.svg.resolver.badge;

import solutions.thex.badgify.svg.SvgResolver;
import solutions.thex.badgify.svg.generator.badge.RTLLinkGenerator;

import java.io.IOException;
import java.util.Map;

/**
 * An implementation of {@link solutions.thex.badgify.svg.SvgResolver} which resolves given parameters by user to
 * a {@link solutions.thex.badgify.svg.resolver.badge.RTLLinkResolver} instance.
 *
 * @author Soroush Shemshadi
 * @version 1.2.0
 * @since 1.0.0
 */
public class RTLLinkResolver extends SvgResolver {

    public String resolve(Map<String, String> params) throws IOException {
        final String bg = resolveBG(params.get("bg"));

        return RTLLinkGenerator.builder()//
                .theme(params.get("theme"))//
                .size(params.get("size"))//
                .title(params.get("title"))//
                .icon(resolveIcon(params.get("icon"), getColor(params, bg)))//
                .link(params.get("link"))//
                .textLength(resolveTextLength(params.get("title"), params.get("size")))
                .titleXPosition(resolveTitleXPosition(params.get("title"), params.get("size")))
                .iconXPosition(resolveIconXPosition(params.get("title"), params.get("size")))
                .width(resolveWidth(params.get("size"), params.get("title")))//
                .height(resolveHeight(params.get("size")))//
                .bg(bg)//
                .color(getColor(params, bg))//
                .build().render();
    }

    private String resolveTitleXPosition(String title, String size) {
        return switch (size) {
            case "s" -> String.valueOf((int) Math.ceil((((title.length() * 6.4117647) / 2) + 4)) * 10);
            case "m" -> String.valueOf((int) Math.ceil((((title.length() * 7.05882353) / 2) + 5)) * 10);
            case "l" -> String.valueOf((int) Math.ceil((((title.length() * 8.2352941) / 2) + 5)) * 10);
            default -> "";
        };
    }

    private String resolveIconXPosition(String title, String size) {
        return switch (size) {
            case "s" -> String.valueOf((int) Math.ceil(((title.length() * 6.4117647) + 8)));
            case "m" -> String.valueOf((int) Math.ceil(((title.length() * 7.05882353) + 8)));
            case "l" -> String.valueOf((int) Math.ceil(((title.length() * 8.2352941) + 8)));
            default -> "";
        };
    }

}
