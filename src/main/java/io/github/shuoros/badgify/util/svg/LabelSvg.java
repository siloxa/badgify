package io.github.shuoros.badgify.util.svg;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.shuoros.badgify.domain.model.badge.LabelBadge;
import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class LabelSvg extends AbstractSvg {

    @JsonIgnore
    private LabelBadge badge;

    private Integer width;

    private Integer height;

    private Integer fontSize;

    private Integer iconSize;

    private Integer iconPosition;

    private Integer textLength;

    private Integer textXPosition;

    private Integer textYPosition;

    private Integer shadowYPosition;

    @Override
    public Map<String, Object> toMap() {
        final Map<String, Object> mapOfLabelBadge = toStringObjectMap(this.badge);
        System.out.println(mapOfLabelBadge);
        mapOfLabelBadge.putAll(toStringObjectMap(this));
        return mapOfLabelBadge;
    }

    public LabelSvg calculateSvgParams() {
        this.width = resolveWidth(this.badge.getSize(), this.badge.getText().length());
        this.height = resolveHeight(this.badge.getSize());
        this.fontSize = resolveFontSize(this.badge.getSize());
        this.iconSize = resolveIconSize(this.badge.getSize());
        this.iconPosition = resolveIconPosition(this.badge.getSize());
        this.textLength = resolveTextLength(this.badge.getSize(), this.badge.getText().length());
        this.textXPosition = resolveTextXPosition(this.badge.getSize(), this.badge.getText().length());
        this.textYPosition = resolveTextYPosition(this.badge.getSize());
        this.shadowYPosition = resolveShadowYPosition(this.badge.getSize());
        return this;
    }
}
