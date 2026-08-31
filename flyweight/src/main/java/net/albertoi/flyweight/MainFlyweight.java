package net.albertoi.flyweight;

import java.util.logging.Logger;

public class MainFlyweight {

    private static final Logger LOGGER = Logger.getLogger(MainFlyweight.class.getName());

    public static void main(String[] args) {
        TransitSymbolFactory styles = new TransitSymbolFactory();
        TransitMap map = new TransitMap(styles);

        map.addStop("Museum", 12, 8, "River Line", "blue", "BUS");
        map.addStop("University", 18, 14, "River Line", "blue", "BUS");
        map.addStop("Central Market", 9, 20, "Garden Line", "green", "TRAM");

        map.render().forEach(LOGGER::info);
        LOGGER.info(() -> "Only " + styles.cachedStyleCount() + " shared styles were created");
    }
}
