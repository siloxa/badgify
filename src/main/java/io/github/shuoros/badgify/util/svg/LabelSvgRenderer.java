package io.github.shuoros.badgify.util.svg;

import java.util.Map;
import lombok.Builder;

@Builder
public class LabelSvgRenderer extends AbstractSvgRenderer {

    private LabelSvg labelSvg;

    @Override
    public Map<String, Object> getParameters() {
        return labelSvg.toMap();
    }

    @Override
    public String getTemplatePath() {
        return ("templates/svg/link/" + labelSvg.getLabelBadge().getTheme().toString() + ".svg.soy");
    }
}
