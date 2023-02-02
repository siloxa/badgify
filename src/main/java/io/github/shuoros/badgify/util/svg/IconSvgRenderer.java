package io.github.shuoros.badgify.util.svg;

import java.util.Map;
import lombok.Builder;

@Builder
public class IconSvgRenderer extends AbstractSvgRenderer {

    private IconSvg svg;

    @Override
    public Map<String, String> getParameters() {
        return svg.toMap();
    }

    @Override
    public String getTemplatePath() {
        return ("templates/svg/icon/" + svg.getBadge().getTheme().toString() + ".svg.soy");
    }
}
