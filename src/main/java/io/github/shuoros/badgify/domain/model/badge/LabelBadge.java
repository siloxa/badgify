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
public class LabelBadge extends AbstractBadge {

    public static final String LABEL_PATH = "label/";
    private String text;

    private AbstractIcon icon;

    @Override
    public void fillByDefaultValues(AbstractBadge defaultBadge) {
        super.fillByDefaultValues(defaultBadge);
        if (this.getText() == null) this.setText(((LabelBadge) defaultBadge).getText());
        if (this.getIcon() == null) this.setIcon(((LabelBadge) defaultBadge).getIcon());
    }

    @Override
    public String getTemplatePath() {
        return TEMPLATES_SVG_PATH + LABEL_PATH + getTheme().toString() + SVG_SOY_EXTENSION;
    }

    @Override
    public Map<String, String> getParameters() {
        return Map.ofEntries(
            Map.entry("text", getText()),
            Map.entry("icon", getIcon().toString()),
            Map.entry("backgroundColor", getBackgroundColor().toString()),
            Map.entry("fontColor", getFontColor().toString()),
            Map.entry("link", getLink()),
            Map.entry("width", resolveWidth(getSize(), getText().length())),
            Map.entry("height", resolveHeight(getSize())),
            Map.entry("fontSize", resolveFontSize(getSize())),
            Map.entry("iconSize", resolveIconSize(getSize())),
            Map.entry("iconPosition", resolveIconPosition(getSize())),
            Map.entry("textLength", resolveTextLength(getSize(), getText().length())),
            Map.entry("textXPosition", resolveTextXPosition(getSize(), getText().length())),
            Map.entry("textYPosition", resolveTextYPosition(getSize())),
            Map.entry("shadowYPosition", resolveShadowYPosition(getSize()))
        );
    }
}
