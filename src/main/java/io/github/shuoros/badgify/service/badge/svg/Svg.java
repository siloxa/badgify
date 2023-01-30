package io.github.shuoros.badgify.service.badge.svg;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.shuoros.badgify.domain.enumeration.Size;
import io.github.shuoros.badgify.service.badge.errors.InvalidSizeException;
import java.util.Map;

public interface Svg {
    double SMALL_SVG_CHAR_LENGTH_FACTOR = 6.4117647;
    double MEDIUM_SVG_CHAR_LENGTH_FACTOR = 7.05882353;
    double LARGE_SVG_CHAR_LENGTH_FACTOR = 8.2352941;
    int SMALL_SVG_WIDTH_PADDING = 29;
    int MEDIUM_SVG_WIDTH_PADDING = 33;
    int LARGE_SVG_WIDTH_PADDING = 40;
    int SMALL_SVG_HEIGHT = 24;
    int MEDIUM_SVG_HEIGHT = 29;
    int LARGE_SVG_HEIGHT = 35;
    int SMALL_SVG_TEXT_POSITION_LEFT_MARGIN = 24;
    int MEDIUM_SVG_TEXT_POSITION_LEFT_MARGIN = 27;
    int LARGE_SVG_TEXT_POSITION_LEFT_MARGIN = 34;
    int TEN_FACTOR = 10;
    int MIDDLE_DIVIDER = 2;

    Map<String, Object> toMap();

    Svg calculateSvgParams();

    default Map<String, Object> toStringObjectMap(Object obj) {
        return new ObjectMapper().convertValue(obj, new TypeReference<Map<String, Object>>() {});
    }

    default Integer resolveWidth(Size size, Integer textChars) {
        if (Size.S == size) {
            return (int) Math.ceil((textChars * SMALL_SVG_CHAR_LENGTH_FACTOR) + SMALL_SVG_WIDTH_PADDING);
        } else if (Size.M == size) {
            return (int) Math.ceil((textChars * MEDIUM_SVG_CHAR_LENGTH_FACTOR) + MEDIUM_SVG_WIDTH_PADDING);
        } else if (Size.L == size) {
            return (int) Math.ceil((textChars * LARGE_SVG_CHAR_LENGTH_FACTOR) + LARGE_SVG_WIDTH_PADDING);
        }
        throw new InvalidSizeException();
    }

    default Integer resolveHeight(Size size) {
        if (Size.S == size) {
            return SMALL_SVG_HEIGHT;
        } else if (Size.M == size) {
            return MEDIUM_SVG_HEIGHT;
        } else if (Size.L == size) {
            return LARGE_SVG_HEIGHT;
        }
        throw new InvalidSizeException();
    }

    default Integer resolveTextLength(Size size, Integer textChars) {
        if (Size.S == size) {
            return (int) Math.ceil(textChars * SMALL_SVG_CHAR_LENGTH_FACTOR) * TEN_FACTOR;
        } else if (Size.M == size) {
            return (int) Math.ceil(textChars * MEDIUM_SVG_CHAR_LENGTH_FACTOR) * TEN_FACTOR;
        } else if (Size.L == size) {
            return (int) Math.ceil(textChars * LARGE_SVG_CHAR_LENGTH_FACTOR) * TEN_FACTOR;
        }
        throw new InvalidSizeException();
    }

    default Integer resolveTextPosition(Size size, Integer textChars) {
        if (Size.S == size) {
            return (
                (int) Math.ceil((((textChars * SMALL_SVG_CHAR_LENGTH_FACTOR) / MIDDLE_DIVIDER) + SMALL_SVG_TEXT_POSITION_LEFT_MARGIN)) *
                TEN_FACTOR
            );
        } else if (Size.M == size) {
            return (
                (int) Math.ceil((((textChars * MEDIUM_SVG_CHAR_LENGTH_FACTOR) / MIDDLE_DIVIDER) + MEDIUM_SVG_TEXT_POSITION_LEFT_MARGIN)) *
                TEN_FACTOR
            );
        } else if (Size.L == size) {
            return (
                (int) Math.ceil((((textChars * LARGE_SVG_CHAR_LENGTH_FACTOR) / MIDDLE_DIVIDER) + LARGE_SVG_TEXT_POSITION_LEFT_MARGIN)) *
                TEN_FACTOR
            );
        }
        throw new InvalidSizeException();
    }
}
