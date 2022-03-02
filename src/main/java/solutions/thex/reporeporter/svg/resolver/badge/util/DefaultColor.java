package solutions.thex.reporeporter.svg.resolver.badge.util;

public enum DefaultColor {

    RED("red", 147, 2, 0),
    BLUE("blue", 15, 127, 191),
    GREEN("green", 121, 181, 16),
    YELLOW("yellow", 204, 174, 4),
    ORANGE("orange", 219, 132, 0),
    PURPLE("purple", 120, 17, 64),
    PINK("pink", 184, 17, 159),
    GREY("grey", 115, 115, 115),
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

    @Override
    public String toString() {
        return "rgb(" + r + ", " + g + ", " + b + ")";
    }

}
