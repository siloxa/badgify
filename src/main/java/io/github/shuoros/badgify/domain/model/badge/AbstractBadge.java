package io.github.shuoros.badgify.domain.model.badge;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.shuoros.badgify.domain.enumeration.Size;
import io.github.shuoros.badgify.domain.enumeration.Theme;
import io.github.shuoros.badgify.domain.model.badge.svg.SvgRenderer;
import io.github.shuoros.badgify.domain.model.color.AbstractColor;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes(
    {
        @JsonSubTypes.Type(CounterBadge.class),
        @JsonSubTypes.Type(IconBadge.class),
        @JsonSubTypes.Type(LabelBadge.class),
        @JsonSubTypes.Type(TextBadge.class),
    }
)
public abstract class AbstractBadge implements SvgRenderer, Serializable {

    protected static final String TEMPLATES_SVG_PATH = "templates/svg/";
    protected static final String SVG_SOY_EXTENSION = ".svg.soy";

    private Theme theme;

    private Size size;

    private AbstractColor backgroundColor;

    private AbstractColor fontColor;

    private String link;

    public void fillByDefaultValues(AbstractBadge defaultBadge) {
        if (this.getTheme() == null) this.setTheme(defaultBadge.getTheme());
        if (this.getSize() == null) this.setSize(defaultBadge.getSize());
        if (this.getBackgroundColor() == null) this.setBackgroundColor(defaultBadge.getBackgroundColor());
        if (this.getFontColor() == null) this.setFontColor(defaultBadge.getFontColor());
        if (this.getLink() == null) this.setLink(defaultBadge.getLink());
    }
}
