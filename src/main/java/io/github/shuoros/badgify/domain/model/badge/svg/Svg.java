package io.github.shuoros.badgify.domain.model.badge.svg;

import io.github.shuoros.badgify.domain.enumeration.Size;
import io.github.shuoros.badgify.domain.model.errors.InvalidSizeException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public interface Svg {
    double SMALL_SVG_CHAR_LENGTH_FACTOR = 6.4117647;
    double MEDIUM_SVG_CHAR_LENGTH_FACTOR = 7.05882353;
    double LARGE_SVG_CHAR_LENGTH_FACTOR = 8.2352941;
    int SMALL_SVG_WIDTH_PADDING = 29;
    int MEDIUM_SVG_WIDTH_PADDING = 33;
    int LARGE_SVG_WIDTH_PADDING = 40;
    String SMALL_SVG_HEIGHT = "24";
    String MEDIUM_SVG_HEIGHT = "29";
    String LARGE_SVG_HEIGHT = "35";
    String SMALL_SVG_FONT = "110";
    String MEDIUM_SVG_FONT = "130";
    String LARGE_SVG_FONT = "150";
    String SMALL_SVG_ICON = "16";
    String MEDIUM_SVG_ICON = "18";
    String LARGE_SVG_ICON = "25";
    String SMALL_SVG_ICON_POSITION = "4";
    String MEDIUM_SVG_ICON_POSITION = "5";
    String LARGE_SVG_ICON_POSITION = "5";
    int SMALL_SVG_TEXT_X_POSITION_LEFT_MARGIN = 24;
    int MEDIUM_SVG_TEXT_X_POSITION_LEFT_MARGIN = 27;
    int LARGE_SVG_TEXT_X_POSITION_LEFT_MARGIN = 34;
    int TEN_FACTOR = 10;
    int MIDDLE_DIVIDER = 2;
    int SMALL_SVG_TEXT_Y_POSITION = 160;
    int MEDIUM_SVG_TEXT_Y_POSITION = 185;
    int LARGE_SVG_TEXT_Y_POSITION = 215;
    int Y_SHADOW_LENGTH = 10;

    default Map<String, String> objectToMap(Object obj) {
        Map<String, String> hashMap = new HashMap<>();
        try {
            final Class<?> aClass = obj.getClass();
            final Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                if (method.getName().indexOf("get") == 0) {
                    String name = method.getName().toLowerCase().charAt(3) + method.getName().substring(4);
                    hashMap.put(name, method.invoke(obj).toString());
                }
            }
        } catch (Throwable e) {
            //log error
        }
        return hashMap;
    }

    default String resolveWidth(Size size, Integer textChars) {
        if (Size.S == size) {
            return String.valueOf((int) Math.ceil((textChars * SMALL_SVG_CHAR_LENGTH_FACTOR) + SMALL_SVG_WIDTH_PADDING));
        } else if (Size.M == size) {
            return String.valueOf((int) Math.ceil((textChars * MEDIUM_SVG_CHAR_LENGTH_FACTOR) + MEDIUM_SVG_WIDTH_PADDING));
        } else if (Size.L == size) {
            return String.valueOf((int) Math.ceil((textChars * LARGE_SVG_CHAR_LENGTH_FACTOR) + LARGE_SVG_WIDTH_PADDING));
        }
        throw new InvalidSizeException();
    }

    default String resolveHeight(Size size) {
        if (Size.S == size) {
            return SMALL_SVG_HEIGHT;
        } else if (Size.M == size) {
            return MEDIUM_SVG_HEIGHT;
        } else if (Size.L == size) {
            return LARGE_SVG_HEIGHT;
        }
        throw new InvalidSizeException();
    }

    default String resolveFontSize(Size size) {
        if (Size.S == size) {
            return SMALL_SVG_FONT;
        } else if (Size.M == size) {
            return MEDIUM_SVG_FONT;
        } else if (Size.L == size) {
            return LARGE_SVG_FONT;
        }
        throw new InvalidSizeException();
    }

    default String resolveIconSize(Size size) {
        if (Size.S == size) {
            return SMALL_SVG_ICON;
        } else if (Size.M == size) {
            return MEDIUM_SVG_ICON;
        } else if (Size.L == size) {
            return LARGE_SVG_ICON;
        }
        throw new InvalidSizeException();
    }

    default String resolveIconPosition(Size size) {
        if (Size.S == size) {
            return SMALL_SVG_ICON_POSITION;
        } else if (Size.M == size) {
            return MEDIUM_SVG_ICON_POSITION;
        } else if (Size.L == size) {
            return LARGE_SVG_ICON_POSITION;
        }
        throw new InvalidSizeException();
    }

    default String resolveTextLength(Size size, Integer textChars) {
        if (Size.S == size) {
            return String.valueOf((int) Math.ceil(textChars * SMALL_SVG_CHAR_LENGTH_FACTOR) * TEN_FACTOR);
        } else if (Size.M == size) {
            return String.valueOf((int) Math.ceil(textChars * MEDIUM_SVG_CHAR_LENGTH_FACTOR) * TEN_FACTOR);
        } else if (Size.L == size) {
            return String.valueOf((int) Math.ceil(textChars * LARGE_SVG_CHAR_LENGTH_FACTOR) * TEN_FACTOR);
        }
        throw new InvalidSizeException();
    }

    default String resolveTextXPosition(Size size, Integer textChars) {
        if (Size.S == size) {
            return String.valueOf(
                (
                    (int) Math.ceil(
                        (((textChars * SMALL_SVG_CHAR_LENGTH_FACTOR) / MIDDLE_DIVIDER) + SMALL_SVG_TEXT_X_POSITION_LEFT_MARGIN)
                    ) *
                    TEN_FACTOR
                )
            );
        } else if (Size.M == size) {
            return String.valueOf(
                (
                    (int) Math.ceil(
                        (((textChars * MEDIUM_SVG_CHAR_LENGTH_FACTOR) / MIDDLE_DIVIDER) + MEDIUM_SVG_TEXT_X_POSITION_LEFT_MARGIN)
                    ) *
                    TEN_FACTOR
                )
            );
        } else if (Size.L == size) {
            return String.valueOf(
                (
                    (int) Math.ceil(
                        (((textChars * LARGE_SVG_CHAR_LENGTH_FACTOR) / MIDDLE_DIVIDER) + LARGE_SVG_TEXT_X_POSITION_LEFT_MARGIN)
                    ) *
                    TEN_FACTOR
                )
            );
        }
        throw new InvalidSizeException();
    }

    default String resolveTextYPosition(Size size) {
        if (Size.S == size) {
            return String.valueOf(SMALL_SVG_TEXT_Y_POSITION);
        } else if (Size.M == size) {
            return String.valueOf(MEDIUM_SVG_TEXT_Y_POSITION);
        } else if (Size.L == size) {
            return String.valueOf(LARGE_SVG_TEXT_Y_POSITION);
        }
        throw new InvalidSizeException();
    }

    default String resolveShadowYPosition(Size size) {
        if (Size.S == size) {
            return String.valueOf(SMALL_SVG_TEXT_Y_POSITION + Y_SHADOW_LENGTH);
        } else if (Size.M == size) {
            return String.valueOf(MEDIUM_SVG_TEXT_Y_POSITION + Y_SHADOW_LENGTH);
        } else if (Size.L == size) {
            return String.valueOf(LARGE_SVG_TEXT_Y_POSITION + Y_SHADOW_LENGTH);
        }
        throw new InvalidSizeException();
    }
}
