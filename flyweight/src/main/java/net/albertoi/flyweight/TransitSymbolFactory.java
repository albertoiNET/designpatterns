package net.albertoi.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TransitSymbolFactory {

    private final Map<StyleKey, TransitSymbolStyle> styles = new HashMap<>();

    public TransitSymbolStyle getStyle(String lineName, String color, String icon) {
        StyleKey key = new StyleKey(lineName, color, icon);
        return styles.computeIfAbsent(
            key,
            ignored -> new TransitSymbolStyle(lineName, color, icon)
        );
    }

    public int cachedStyleCount() {
        return styles.size();
    }

    private record StyleKey(String lineName, String color, String icon) {
    }
}
