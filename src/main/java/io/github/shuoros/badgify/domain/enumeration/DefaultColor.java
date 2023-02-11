package io.github.shuoros.badgify.domain.enumeration;

import io.github.shuoros.badgify.domain.model.color.RgbColor;

public enum DefaultColor {
    RED("red", RgbColor.of(190, 30, 45)),
    BLUE("blue", RgbColor.of(28, 117, 188)),
    GREEN("green", RgbColor.of(120, 193, 67)),
    YELLOW("yellow", RgbColor.of(231, 209, 35)),
    ORANGE("orange", RgbColor.of(245, 119, 31)),
    PURPLE("purple", RgbColor.of(127, 63, 152)),
    PINK("pink", RgbColor.of(255, 17, 125)),
    BROWN("brown", RgbColor.of(117, 76, 41)),
    INDIGO("indigo", RgbColor.of(38, 34, 98)),
    GRAY("gray", RgbColor.of(115, 115, 115)),
    LAVENDER("lavender", RgbColor.of(199, 153, 198)),
    CYAN("cyan", RgbColor.of(111, 204, 221)),
    BLACK("black", RgbColor.of(0, 0, 0)),
    WHITE("white", RgbColor.of(255, 255, 255));

    private String name;
    private RgbColor color;

    DefaultColor(String name, RgbColor color) {
        this.name = name;
        this.color = color;
    }

    public static DefaultColor findByName(String name) {
        for (DefaultColor color : DefaultColor.values()) {
            if (color.name.equalsIgnoreCase(name)) {
                return color;
            }
        }
        return null;
    }

    public RgbColor getColor() {
        return color;
    }
}
