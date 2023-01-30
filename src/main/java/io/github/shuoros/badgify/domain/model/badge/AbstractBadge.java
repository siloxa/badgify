package io.github.shuoros.badgify.domain.model.badge;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.github.shuoros.badgify.domain.enumeration.Size;
import io.github.shuoros.badgify.domain.enumeration.Theme;
import io.github.shuoros.badgify.domain.model.color.Color;
import io.github.shuoros.badgify.util.ColorEditor;
import javax.persistence.Convert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractBadge {

    private Theme theme;

    private Size size;

    @JsonSerialize(using = ToStringSerializer.class)
    private Color backgroundColor;

    @JsonSerialize(using = ToStringSerializer.class)
    private Color fontColor;

    private String link;

    public void fillByDefaultValues(AbstractBadge defaultBadge) {
        if (this.getTheme() == null) this.setTheme(defaultBadge.getTheme());
        if (this.getSize() == null) this.setSize(defaultBadge.getSize());
        if (this.getBackgroundColor() == null) this.setBackgroundColor(defaultBadge.getBackgroundColor());
        if (this.getFontColor() == null) this.setFontColor(defaultBadge.getFontColor());
        if (this.getLink() == null) this.setLink(defaultBadge.getLink());
    }
}
