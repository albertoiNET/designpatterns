package net.albertoi.flyweight;

public class TransitStopMarker {

    private final String stopName;
    private final int x;
    private final int y;
    private final TransitSymbolStyle style;

    public TransitStopMarker(String stopName, int x, int y, TransitSymbolStyle style) {
        this.stopName = stopName;
        this.x = x;
        this.y = y;
        this.style = style;
    }

    public String render() {
        return style.render(stopName, x, y);
    }

    public TransitSymbolStyle style() {
        return style;
    }
}
