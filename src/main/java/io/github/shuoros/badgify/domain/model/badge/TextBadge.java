package io.github.shuoros.badgify.domain.model.badge;

import io.github.shuoros.badgify.domain.enumeration.Size;
import io.github.shuoros.badgify.domain.model.errors.InvalidSizeException;
import java.util.Map;
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
public class TextBadge extends AbstractBadge {

    public static final String TEXT_PATH = "text/";
    private static final int SVG_WIDTH_PADDING = 10;
    private static final int SVG_TEXT_X_POSITION_MARGIN = 5;

    private String text;

    @Override
    public void fillByDefaultValues(AbstractBadge defaultBadge) {
        super.fillByDefaultValues(defaultBadge);
        if (this.getText() == null) this.setText(((TextBadge) defaultBadge).getText());
    }

    @Override
    public String getTemplatePath() {
        return TEMPLATES_SVG_PATH + TEXT_PATH + getTheme().toString() + SVG_SOY_EXTENSION;
    }

    @Override
    public Map<String, String> getParameters() {
        return Map.ofEntries(
            Map.entry("text", getText()),
            Map.entry("backgroundColor", getBackgroundColor().toString()),
            Map.entry("fontColor", getFontColor().toString()),
            Map.entry("link", getLink()),
            Map.entry("width", customResolveWidth(getSize(), getText().length())),
            Map.entry("height", resolveHeight(getSize())),
            Map.entry("fontSize", resolveFontSize(getSize())),
            Map.entry("textLength", resolveTextLength(getSize(), getText().length())),
            Map.entry("textXPosition", customResolveTextXPosition(getSize(), getText().length())),
            Map.entry("textYPosition", resolveTextYPosition(getSize())),
            Map.entry("shadowYPosition", resolveShadowYPosition(getSize()))
        );
    }

    protected static String customResolveWidth(Size size, Integer textChars) {
        if (Size.S == size) {
            return String.valueOf((int) Math.ceil((textChars * SMALL_SVG_CHAR_LENGTH_FACTOR) + SVG_WIDTH_PADDING));
        } else if (Size.M == size) {
            return String.valueOf((int) Math.ceil((textChars * MEDIUM_SVG_CHAR_LENGTH_FACTOR) + SVG_WIDTH_PADDING));
        } else if (Size.L == size) {
            return String.valueOf((int) Math.ceil((textChars * LARGE_SVG_CHAR_LENGTH_FACTOR) + SVG_WIDTH_PADDING));
        }
        throw new InvalidSizeException();
    }

    protected static String customResolveTextXPosition(Size size, Integer textChars) {
        if (Size.S == size) {
            return String.valueOf(
                ((int) Math.ceil((((textChars * SMALL_SVG_CHAR_LENGTH_FACTOR) / MIDDLE_DIVIDER) + SVG_TEXT_X_POSITION_MARGIN)) * TEN_FACTOR)
            );
        } else if (Size.M == size) {
            return String.valueOf(
                (
                    (int) Math.ceil((((textChars * MEDIUM_SVG_CHAR_LENGTH_FACTOR) / MIDDLE_DIVIDER) + SVG_TEXT_X_POSITION_MARGIN)) *
                    TEN_FACTOR
                )
            );
        } else if (Size.L == size) {
            return String.valueOf(
                ((int) Math.ceil((((textChars * LARGE_SVG_CHAR_LENGTH_FACTOR) / MIDDLE_DIVIDER) + SVG_TEXT_X_POSITION_MARGIN)) * TEN_FACTOR)
            );
        }
        throw new InvalidSizeException();
    }
}
