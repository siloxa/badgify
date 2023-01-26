package io.github.shuoros.badgify.domain.model.badge;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LabelBadge extends AbstractBadge {

    private String text;

    private String icon;

    @Override
    public void fillByDefaultValues(AbstractBadge defaultBadge) {
        super.fillByDefaultValues(defaultBadge);
        if (this.getText() == null) this.setText(((LabelBadge) defaultBadge).getText());
        if (this.getIcon() == null) this.setIcon(((LabelBadge) defaultBadge).getIcon());
    }
}
