package io.github.shuoros.badgify.domain.model.badge;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.github.shuoros.badgify.domain.model.icon.AbstractIcon;
import io.github.shuoros.badgify.domain.model.icon.FontAwesomeIcon;
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

    @JsonSerialize(using = ToStringSerializer.class)
    private AbstractIcon icon;

    @Override
    public void fillByDefaultValues(AbstractBadge defaultBadge) {
        super.fillByDefaultValues(defaultBadge);
        if (this.getIcon() == null) this.setIcon(((IconBadge) defaultBadge).getIcon());
    }
}
