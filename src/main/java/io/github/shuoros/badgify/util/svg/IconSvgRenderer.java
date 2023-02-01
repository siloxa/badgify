package io.github.shuoros.badgify.util.svg;

import java.util.Map;
import lombok.Builder;

@Builder
public class IconSvgRenderer extends AbstractSvgRenderer {

    private IconSvg iconSvg;

    @Override
    public Map<String, Object> getParameters() {
        return iconSvg.toMap();
    }

    @Override
    public String getTemplatePath() {
        return ("templates/svg/icon/" + iconSvg.getIconBadge().getTheme().toString() + ".svg.soy");
    }
}
