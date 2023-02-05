package io.github.shuoros.badgify.domain.model.badge;

import io.github.shuoros.badgify.domain.enumeration.CounterBadgeType;
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
public class CounterBadge extends AbstractBadge {

    private String text;

    private String id;

    private CounterBadgeType type;

    private AbstractIcon icon;

    private Boolean noIcon;

    private Boolean doNotCount;

    @Override
    public void fillByDefaultValues(AbstractBadge defaultBadge) {
        super.fillByDefaultValues(defaultBadge);
        if (this.getText() == null) this.setText(((CounterBadge) defaultBadge).getText());
        if (this.getIcon() == null) this.setIcon(((CounterBadge) defaultBadge).getIcon());
        if (this.getNoIcon() == null) this.setNoIcon(((CounterBadge) defaultBadge).getNoIcon());
        if (this.getDoNotCount() == null) this.setDoNotCount(((CounterBadge) defaultBadge).getDoNotCount());
    }

    @Override
    public String getTemplatePath() {
        return (
            TEMPLATES_SVG_PATH + ((getNoIcon()) ? TextBadge.TEXT_PATH : LabelBadge.LABEL_PATH) + getTheme().toString() + SVG_SOY_EXTENSION
        );
    }

    @Override
    public Map<String, String> getParameters() {
        return (getNoIcon()) ? getParametersAsTextBadge() : getParametersAsLabelBadge();
    }

    private Map<String, String> getParametersAsTextBadge() {
        return TextBadge
            .builder()
            .text(getText())
            .theme(getTheme())
            .size(getSize())
            .backgroundColor(getBackgroundColor())
            .fontColor(getFontColor())
            .link(getLink())
            .build()
            .getParameters();
    }

    private Map<String, String> getParametersAsLabelBadge() {
        return LabelBadge
            .builder()
            .text(getText())
            .icon(getIcon())
            .theme(getTheme())
            .size(getSize())
            .backgroundColor(getBackgroundColor())
            .fontColor(getFontColor())
            .link(getLink())
            .build()
            .getParameters();
    }
}
