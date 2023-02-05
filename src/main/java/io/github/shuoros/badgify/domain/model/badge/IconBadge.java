package io.github.shuoros.badgify.domain.model.badge;

import io.github.shuoros.badgify.domain.model.icon.AbstractIcon;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class IconBadge extends AbstractBadge {

    public static final String ICON_PATH = "icon/";

    private AbstractIcon icon;

    @Override
    public void fillByDefaultValues(AbstractBadge defaultBadge) {
        super.fillByDefaultValues(defaultBadge);
        if (this.getIcon() == null) this.setIcon(((IconBadge) defaultBadge).getIcon());
    }

    @Override
    public String getTemplatePath() {
        return TEMPLATES_SVG_PATH + ICON_PATH + getTheme().toString() + SVG_SOY_EXTENSION;
    }

    @Override
    public Map<String, String> getParameters() {
        return Map.ofEntries(
            Map.entry("icon", getIcon().toString()),
            Map.entry("backgroundColor", getBackgroundColor().toString()),
            Map.entry("fontColor", getFontColor().toString()),
            Map.entry("link", getLink()),
            Map.entry("width", resolveHeight(getSize())),
            Map.entry("height", resolveHeight(getSize())),
            Map.entry("fontSize", resolveFontSize(getSize())),
            Map.entry("iconSize", resolveIconSize(getSize())),
            Map.entry("iconPosition", resolveIconPosition(getSize()))
        );
    }
}
