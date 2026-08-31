package net.albertoi.flyweight;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

class FlyweightTest {

    @Test
    void reusesIntrinsicStyleDataAcrossManyStops() {
        TransitSymbolFactory factory = new TransitSymbolFactory();
        TransitMap map = new TransitMap(factory);

        TransitStopMarker first = map.addStop("Harbor", 2, 4, "Blue Line", "blue", "FERRY");
        TransitStopMarker second = map.addStop("Library", 8, 9, "Blue Line", "blue", "FERRY");

        assertSame(first.style(), second.style());
        assertEquals(1, factory.cachedStyleCount());
        assertEquals(2, map.render().size());
    }

    @Test
    void createsANewFlyweightOnlyForDifferentIntrinsicData() {
        TransitSymbolFactory factory = new TransitSymbolFactory();

        TransitSymbolStyle bus = factory.getStyle("Circle", "orange", "BUS");
        TransitSymbolStyle tram = factory.getStyle("Circle", "orange", "TRAM");

        assertNotSame(bus, tram);
        assertEquals(2, factory.cachedStyleCount());
        assertEquals(
            List.of("BUS Circle (orange) at East Gate [1,3]"),
            List.of(bus.render("East Gate", 1, 3))
        );
    }
}
