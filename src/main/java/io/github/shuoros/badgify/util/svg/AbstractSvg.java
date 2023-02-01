package io.github.shuoros.badgify.util.svg;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.shuoros.badgify.domain.enumeration.Size;
import io.github.shuoros.badgify.service.badge.errors.InvalidSizeException;
import java.util.Map;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class AbstractSvg {

    protected static final double SMALL_SVG_CHAR_LENGTH_FACTOR = 6.4117647;
    protected static final double MEDIUM_SVG_CHAR_LENGTH_FACTOR = 7.05882353;
    protected static final double LARGE_SVG_CHAR_LENGTH_FACTOR = 8.2352941;
    private static final int SMALL_SVG_WIDTH_PADDING = 29;
    private static final int MEDIUM_SVG_WIDTH_PADDING = 33;
    private static final int LARGE_SVG_WIDTH_PADDING = 40;
    private static final int SMALL_SVG_HEIGHT = 24;
    private static final int MEDIUM_SVG_HEIGHT = 29;
    private static final int LARGE_SVG_HEIGHT = 35;
    private static final int SMALL_SVG_FONT = 110;
    private static final int MEDIUM_SVG_FONT = 130;
    private static final int LARGE_SVG_FONT = 150;
    private static final int SMALL_SVG_ICON = 16;
    private static final int MEDIUM_SVG_ICON = 18;
    private static final int LARGE_SVG_ICON = 25;
    private static final int SMALL_SVG_ICON_POSITION = 4;
    private static final int MEDIUM_SVG_ICON_POSITION = 5;
    private static final int LARGE_SVG_ICON_POSITION = 5;
    private static final int SMALL_SVG_TEXT_X_POSITION_LEFT_MARGIN = 24;
    private static final int MEDIUM_SVG_TEXT_X_POSITION_LEFT_MARGIN = 27;
    private static final int LARGE_SVG_TEXT_X_POSITION_LEFT_MARGIN = 34;
    protected static final int TEN_FACTOR = 10;
    protected static final int MIDDLE_DIVIDER = 2;
    private static final int SMALL_SVG_TEXT_Y_POSITION = 160;
    private static final int MEDIUM_SVG_TEXT_Y_POSITION = 185;
    private static final int LARGE_SVG_TEXT_Y_POSITION = 215;
    private static final int Y_SHADOW_LENGTH = 10;

    public abstract Map<String, Object> toMap();

    public abstract AbstractSvg calculateSvgParams();

    protected static Map<String, Object> toStringObjectMap(Object obj) {
        return new ObjectMapper().convertValue(obj, new TypeReference<Map<String, Object>>() {});
    }

    protected static Integer resolveWidth(Size size, Integer textChars) {
        if (Size.S == size) {
            return (int) Math.ceil((textChars * SMALL_SVG_CHAR_LENGTH_FACTOR) + SMALL_SVG_WIDTH_PADDING);
        } else if (Size.M == size) {
            return (int) Math.ceil((textChars * MEDIUM_SVG_CHAR_LENGTH_FACTOR) + MEDIUM_SVG_WIDTH_PADDING);
        } else if (Size.L == size) {
            return (int) Math.ceil((textChars * LARGE_SVG_CHAR_LENGTH_FACTOR) + LARGE_SVG_WIDTH_PADDING);
        }
        throw new InvalidSizeException();
    }

    protected static Integer resolveHeight(Size size) {
        if (Size.S == size) {
            return SMALL_SVG_HEIGHT;
        } else if (Size.M == size) {
            return MEDIUM_SVG_HEIGHT;
        } else if (Size.L == size) {
            return LARGE_SVG_HEIGHT;
        }
        throw new InvalidSizeException();
    }

    protected static Integer resolveFontSize(Size size) {
        if (Size.S == size) {
            return SMALL_SVG_FONT;
        } else if (Size.M == size) {
            return MEDIUM_SVG_FONT;
        } else if (Size.L == size) {
            return LARGE_SVG_FONT;
        }
        throw new InvalidSizeException();
    }

    protected static Integer resolveIconSize(Size size) {
        if (Size.S == size) {
            return SMALL_SVG_ICON;
        } else if (Size.M == size) {
            return MEDIUM_SVG_ICON;
        } else if (Size.L == size) {
            return LARGE_SVG_ICON;
        }
        throw new InvalidSizeException();
    }

    protected static Integer resolveIconPosition(Size size) {
        if (Size.S == size) {
            return SMALL_SVG_ICON_POSITION;
        } else if (Size.M == size) {
            return MEDIUM_SVG_ICON_POSITION;
        } else if (Size.L == size) {
            return LARGE_SVG_ICON_POSITION;
        }
        throw new InvalidSizeException();
    }

    protected static Integer resolveTextLength(Size size, Integer textChars) {
        if (Size.S == size) {
            return (int) Math.ceil(textChars * SMALL_SVG_CHAR_LENGTH_FACTOR) * TEN_FACTOR;
        } else if (Size.M == size) {
            return (int) Math.ceil(textChars * MEDIUM_SVG_CHAR_LENGTH_FACTOR) * TEN_FACTOR;
        } else if (Size.L == size) {
            return (int) Math.ceil(textChars * LARGE_SVG_CHAR_LENGTH_FACTOR) * TEN_FACTOR;
        }
        throw new InvalidSizeException();
    }

    protected static Integer resolveTextXPosition(Size size, Integer textChars) {
        if (Size.S == size) {
            return (
                (int) Math.ceil((((textChars * SMALL_SVG_CHAR_LENGTH_FACTOR) / MIDDLE_DIVIDER) + SMALL_SVG_TEXT_X_POSITION_LEFT_MARGIN)) *
                TEN_FACTOR
            );
        } else if (Size.M == size) {
            return (
                (int) Math.ceil((((textChars * MEDIUM_SVG_CHAR_LENGTH_FACTOR) / MIDDLE_DIVIDER) + MEDIUM_SVG_TEXT_X_POSITION_LEFT_MARGIN)) *
                TEN_FACTOR
            );
        } else if (Size.L == size) {
            return (
                (int) Math.ceil((((textChars * LARGE_SVG_CHAR_LENGTH_FACTOR) / MIDDLE_DIVIDER) + LARGE_SVG_TEXT_X_POSITION_LEFT_MARGIN)) *
                TEN_FACTOR
            );
        }
        throw new InvalidSizeException();
    }

    protected static Integer resolveTextYPosition(Size size) {
        if (Size.S == size) {
            return SMALL_SVG_TEXT_Y_POSITION;
        } else if (Size.M == size) {
            return MEDIUM_SVG_TEXT_Y_POSITION;
        } else if (Size.L == size) {
            return LARGE_SVG_TEXT_Y_POSITION;
        }
        throw new InvalidSizeException();
    }

    protected static Integer resolveShadowYPosition(Size size) {
        if (Size.S == size) {
            return SMALL_SVG_TEXT_Y_POSITION + Y_SHADOW_LENGTH;
        } else if (Size.M == size) {
            return MEDIUM_SVG_TEXT_Y_POSITION + Y_SHADOW_LENGTH;
        } else if (Size.L == size) {
            return LARGE_SVG_TEXT_Y_POSITION + Y_SHADOW_LENGTH;
        }
        throw new InvalidSizeException();
    }
}
