package net.albertoi.abstractfactory;

import net.albertoi.abstractfactory.factory.IndoorEquipmentFactory;
import net.albertoi.abstractfactory.factory.OutdoorEquipmentFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AbstractFactoryTest {

    @Test
    void createsACompatibleIndoorEquipmentFamily() {
        EventPlan plan = new EventPlanner(new IndoorEquipmentFactory()).prepareVenue();

        assertEquals("indoor", plan.venueType());
        assertTrue(plan.instructions().contains("Calibrate dimmable ceiling lights"));
        assertTrue(plan.instructions().contains("Set quiet air conditioning to 21 C"));
    }

    @Test
    void switchesTheWholeProductFamilyWithOneFactory() {
        EventPlan plan = new EventPlanner(new OutdoorEquipmentFactory()).prepareVenue();

        assertEquals("outdoor", plan.venueType());
        assertTrue(plan.instructions().contains("Position solar lights along every path"));
        assertTrue(plan.instructions().contains("Activate low-water mist cooling"));
    }
}
