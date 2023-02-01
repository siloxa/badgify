package io.github.shuoros.badgify.util.svg;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.shuoros.badgify.domain.model.badge.IconBadge;
import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class IconSvg extends AbstractSvg {

    @JsonIgnore
    private IconBadge badge;

    private Integer width;

    private Integer height;

    private Integer fontSize;

    private Integer iconSize;

    private Integer iconPosition;

    @Override
    public Map<String, Object> toMap() {
        final Map<String, Object> mapOfLabelBadge = toStringObjectMap(this.badge);
        System.out.println(mapOfLabelBadge);
        mapOfLabelBadge.putAll(toStringObjectMap(this));
        return mapOfLabelBadge;
    }

    public IconSvg calculateSvgParams() {
        this.width = resolveHeight(this.badge.getSize());
        this.height = resolveHeight(this.badge.getSize());
        this.fontSize = resolveFontSize(this.badge.getSize());
        this.iconSize = resolveIconSize(this.badge.getSize());
        this.iconPosition = resolveIconPosition(this.badge.getSize());
        return this;
    }
}
