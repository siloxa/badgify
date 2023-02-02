package io.github.shuoros.badgify.domain.model.badge;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.github.shuoros.badgify.domain.enumeration.CounterBadgeType;
import io.github.shuoros.badgify.domain.model.icon.AbstractIcon;
import io.github.shuoros.badgify.util.jackson.ToIconDeserializer;
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
}
