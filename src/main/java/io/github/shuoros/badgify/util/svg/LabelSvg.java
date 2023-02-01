package io.github.shuoros.badgify.util.svg;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.shuoros.badgify.domain.model.badge.LabelBadge;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class LabelSvg extends AbstractSvg {

    @JsonIgnore
    private LabelBadge labelBadge;

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
        final Map<String, Object> mapOfLabelBadge = toStringObjectMap(this.labelBadge);
        System.out.println(mapOfLabelBadge);
        mapOfLabelBadge.putAll(toStringObjectMap(this));
        return mapOfLabelBadge;
    }

    public LabelSvg calculateSvgParams() {
        this.width = resolveWidth(this.labelBadge.getSize(), this.labelBadge.getText().length());
        this.height = resolveHeight(this.labelBadge.getSize());
        this.fontSize = resolveFontSize(this.labelBadge.getSize());
        this.iconSize = resolveIconSize(this.labelBadge.getSize());
        this.iconPosition = resolveIconPosition(this.labelBadge.getSize());
        this.textLength = resolveTextLength(this.labelBadge.getSize(), this.labelBadge.getText().length());
        this.textXPosition = resolveTextXPosition(this.labelBadge.getSize(), this.labelBadge.getText().length());
        this.textYPosition = resolveTextYPosition(this.labelBadge.getSize());
        this.shadowYPosition = resolveShadowYPosition(this.labelBadge.getSize());
        return this;
    }
}
