package net.albertoi.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecoratorTest {

    @Test
    void addsResponsibilitiesWithoutChangingTheBaseObject() {
        ShippingLabel base = new BasicShippingLabel("Seed Bank", "Greenhouse 2");
        ShippingLabel tracked = new TrackingLabel(base, "SEED-42");

        assertEquals("Deliver to Seed Bank at Greenhouse 2", base.print());
        assertEquals(
            "Deliver to Seed Bank at Greenhouse 2 | Tracking: SEED-42",
            tracked.print()
        );
    }

    @Test
    void stacksDecoratorsAtRuntime() {
        ShippingLabel label = new BasicShippingLabel("Research Kitchen", "Market Hall");
        label = new ColdChainLabel(label, 5);
        label = new TrackingLabel(label, "FOOD-17");

        assertEquals(
            "Deliver to Research Kitchen at Market Hall | Keep below 5 C | Tracking: FOOD-17",
            label.print()
        );
    }
}
