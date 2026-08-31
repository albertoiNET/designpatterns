package net.albertoi.flyweight;

public final class TransitSymbolStyle {

    private final String lineName;
    private final String color;
    private final String icon;

    TransitSymbolStyle(String lineName, String color, String icon) {
        this.lineName = lineName;
        this.color = color;
        this.icon = icon;
    }

    public String render(String stopName, int x, int y) {
        return icon + " " + lineName + " (" + color + ") at " + stopName + " [" + x + "," + y + "]";
    }
}
