package io.github.shuoros.badgify.util.svg;

import java.util.Map;
import lombok.Builder;

@Builder
public class TextSvgRenderer extends AbstractSvgRenderer {

    private TextSvg svg;

    @Override
    public Map<String, String> getParameters() {
        return svg.toMap();
    }

    @Override
    public String getTemplatePath() {
        return ("templates/svg/text/" + svg.getBadge().getTheme().toString() + ".svg.soy");
    }
}
