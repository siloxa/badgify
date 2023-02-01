package io.github.shuoros.badgify.util.svg;

import java.util.Map;
import lombok.Builder;

@Builder
public class LabelSvgRenderer extends AbstractSvgRenderer {

    private LabelSvg svg;

    @Override
    public Map<String, Object> getParameters() {
        return svg.toMap();
    }

    @Override
    public String getTemplatePath() {
        return ("templates/svg/label/" + svg.getBadge().getTheme().toString() + ".svg.soy");
    }
}
