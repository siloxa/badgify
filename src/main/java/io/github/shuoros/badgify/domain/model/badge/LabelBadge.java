package io.github.shuoros.badgify.domain.model.badge;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.github.shuoros.badgify.domain.model.icon.AbstractIcon;
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

    private String text;

    private AbstractIcon icon;

    @Override
    public void fillByDefaultValues(AbstractBadge defaultBadge) {
        super.fillByDefaultValues(defaultBadge);
        if (this.getText() == null) this.setText(((LabelBadge) defaultBadge).getText());
        if (this.getIcon() == null) this.setIcon(((LabelBadge) defaultBadge).getIcon());
    }
}
