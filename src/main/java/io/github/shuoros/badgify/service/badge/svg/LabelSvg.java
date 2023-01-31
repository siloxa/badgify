package io.github.shuoros.badgify.service.badge.svg;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.shuoros.badgify.domain.model.badge.LabelBadge;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LabelSvg implements Svg {

    @JsonIgnore
    private LabelBadge labelBadge;

    private Integer width;

    private Integer height;

    private Integer textLength;

    private Integer textPosition;

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
        this.textLength = resolveTextLength(this.labelBadge.getSize(), this.labelBadge.getText().length());
        this.textPosition = resolveTextPosition(this.labelBadge.getSize(), this.labelBadge.getText().length());
        return this;
    }
}
