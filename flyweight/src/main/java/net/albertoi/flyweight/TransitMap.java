package net.albertoi.flyweight;

import java.util.ArrayList;
import java.util.List;

public class TransitMap {

    private final TransitSymbolFactory symbolFactory;
    private final List<TransitStopMarker> markers = new ArrayList<>();

    public TransitMap(TransitSymbolFactory symbolFactory) {
        this.symbolFactory = symbolFactory;
    }

    public TransitStopMarker addStop(
        String stopName,
        int x,
        int y,
        String lineName,
        String color,
        String icon
    ) {
        TransitSymbolStyle style = symbolFactory.getStyle(lineName, color, icon);
        TransitStopMarker marker = new TransitStopMarker(stopName, x, y, style);
        markers.add(marker);
        return marker;
    }

    public List<String> render() {
        return markers.stream()
            .map(TransitStopMarker::render)
            .toList();
    }
}
