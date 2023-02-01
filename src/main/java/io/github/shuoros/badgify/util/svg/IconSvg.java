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
    private IconBadge iconBadge;

    private Integer width;

    private Integer height;

    private Integer fontSize;

    private Integer iconSize;

    private Integer iconPosition;

    @Override
    public Map<String, Object> toMap() {
        final Map<String, Object> mapOfLabelBadge = toStringObjectMap(this.iconBadge);
        System.out.println(mapOfLabelBadge);
        mapOfLabelBadge.putAll(toStringObjectMap(this));
        return mapOfLabelBadge;
    }

    public IconSvg calculateSvgParams() {
        this.width = resolveHeight(this.iconBadge.getSize());
        this.height = resolveHeight(this.iconBadge.getSize());
        this.fontSize = resolveFontSize(this.iconBadge.getSize());
        this.iconSize = resolveIconSize(this.iconBadge.getSize());
        this.iconPosition = resolveIconPosition(this.iconBadge.getSize());
        return this;
    }
}
