package io.github.shuoros.badgify.util.svg;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.shuoros.badgify.domain.enumeration.Size;
import io.github.shuoros.badgify.domain.model.badge.TextBadge;
import io.github.shuoros.badgify.service.badge.errors.InvalidSizeException;
import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class TextSvg extends AbstractSvg {

    private static final int SVG_WIDTH_PADDING = 10;
    private static final int SVG_TEXT_X_POSITION_MARGIN = 5;

    @JsonIgnore
    private TextBadge badge;

    private Integer width;

    private Integer height;

    private Integer fontSize;

    private Integer textLength;

    private Integer textXPosition;

    private Integer textYPosition;

    private Integer shadowYPosition;

    @Override
    public Map<String, String> toMap() {
        final Map<String, String> mapOfLabelBadge = objectToMap(this.badge);
        mapOfLabelBadge.putAll(objectToMap(this));
        return mapOfLabelBadge;
    }

    public TextSvg calculateSvgParams() {
        this.width = resolveWidth(this.badge.getSize(), this.badge.getText().length());
        this.height = resolveHeight(this.badge.getSize());
        this.fontSize = resolveFontSize(this.badge.getSize());
        this.textLength = resolveTextLength(this.badge.getSize(), this.badge.getText().length());
        this.textXPosition = resolveTextXPosition(this.badge.getSize(), this.badge.getText().length());
        this.textYPosition = resolveTextYPosition(this.badge.getSize());
        this.shadowYPosition = resolveShadowYPosition(this.badge.getSize());
        return this;
    }

    protected static Integer resolveWidth(Size size, Integer textChars) {
        if (Size.S == size) {
            return (int) Math.ceil((textChars * SMALL_SVG_CHAR_LENGTH_FACTOR) + SVG_WIDTH_PADDING);
        } else if (Size.M == size) {
            return (int) Math.ceil((textChars * MEDIUM_SVG_CHAR_LENGTH_FACTOR) + SVG_WIDTH_PADDING);
        } else if (Size.L == size) {
            return (int) Math.ceil((textChars * LARGE_SVG_CHAR_LENGTH_FACTOR) + SVG_WIDTH_PADDING);
        }
        throw new InvalidSizeException();
    }

    protected static Integer resolveTextXPosition(Size size, Integer textChars) {
        if (Size.S == size) {
            return (
                (int) Math.ceil((((textChars * SMALL_SVG_CHAR_LENGTH_FACTOR) / MIDDLE_DIVIDER) + SVG_TEXT_X_POSITION_MARGIN)) * TEN_FACTOR
            );
        } else if (Size.M == size) {
            return (
                (int) Math.ceil((((textChars * MEDIUM_SVG_CHAR_LENGTH_FACTOR) / MIDDLE_DIVIDER) + SVG_TEXT_X_POSITION_MARGIN)) * TEN_FACTOR
            );
        } else if (Size.L == size) {
            return (
                (int) Math.ceil((((textChars * LARGE_SVG_CHAR_LENGTH_FACTOR) / MIDDLE_DIVIDER) + SVG_TEXT_X_POSITION_MARGIN)) * TEN_FACTOR
            );
        }
        throw new InvalidSizeException();
    }
}
