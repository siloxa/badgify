package solutions.thex.reporeporter.svg.resolver.badge;

import solutions.thex.reporeporter.svg.SvgResolver;
import solutions.thex.reporeporter.svg.generator.badge.LogoGenerator;

import java.io.IOException;
import java.util.Map;

/**
 * An implementation of {@link solutions.thex.reporeporter.svg.SvgResolver} which resolves given parameters by user to
 * a {@link solutions.thex.reporeporter.svg.generator.badge.LogoGenerator} instance.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
public class LogoResolver extends SvgResolver {

    @Override
    public String resolve(Map<String, String> params) throws IOException {
        final String bg = resolveBG(params.get("bg"));

        return LogoGenerator.builder()//
                .theme(params.get("theme"))//
                .size(params.get("size"))//
                .title(params.get("logo"))//
                .logo(resolveLogo(params.get("logo"), resolveColor(params.get("color"), bg)))//
                .link(params.get("link"))//
                .width(resolveWidth(params.get("size"), params.get("title")))//
                .height(resolveHeight(params.get("size")))//
                .bg(bg)//
                .build().render();
    }

    @Override
    protected String resolveWidth(String size, String title) {
        return switch (size) {
            case "s" -> "24";
            case "m" -> "29";
            case "l" -> "35";
            default -> "";
        };
    }

}
