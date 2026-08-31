package net.albertoi.composite;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompositeTest {

    @Test
    void treatsALeafAndACompositeThroughTheSameInterface() {
        MaintenanceItem leaf = new MaintenanceTask("Water young trees", 25);
        MaintenanceItem zone = new MaintenanceZone("North garden").add(leaf);

        assertEquals(25, leaf.estimatedMinutes());
        assertEquals(25, zone.estimatedMinutes());
        assertEquals(leaf.taskNames(), zone.taskNames());
    }

    @Test
    void aggregatesNestedZonesRecursively() {
        MaintenanceZone pond = new MaintenanceZone("Pond")
            .add(new MaintenanceTask("Test water quality", 30))
            .add(new MaintenanceTask("Clear leaves", 20));
        MaintenanceZone park = new MaintenanceZone("Park")
            .add(pond)
            .add(new MaintenanceTask("Open gates", 10));

        assertEquals(60, park.estimatedMinutes());
        assertEquals(
            List.of("Test water quality", "Clear leaves", "Open gates"),
            park.taskNames()
        );
    }
}
