package solutions.thex.badgify.svg.resolver.badge.util;

public enum DefaultColor {

    RED("red", 190, 30, 45),
    BLUE("blue", 28, 117, 188),
    GREEN("green", 120, 193, 67),
    YELLOW("yellow", 231, 209, 35),
    ORANGE("orange", 245, 119, 31),
    PURPLE("purple", 127, 63, 152),
    PINK("pink", 255, 17, 125),
    BROWN("brown", 117, 76, 41),
    INDIGO("indigo", 38, 34, 98),
    GRAY("gray", 115, 115, 115),
    LAVENDER("lavender", 199, 153, 198),
    CYAN("cyan", 111, 204, 221),
    BLACK("black", 0, 0, 0),
    WHITE("white", 255, 255, 255);

    private String name;
    private int r;
    private int g;
    private int b;

    DefaultColor(String name, int r, int g, int b) {
        this.name = name;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static DefaultColor getColor(String name) {
        for (DefaultColor color : DefaultColor.values()) {
            if (color.name.equalsIgnoreCase(name)) {
                return color;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "rgb(" + r + ", " + g + ", " + b + ")";
    }

}
