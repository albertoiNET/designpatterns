package net.albertoi.strategy;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategyTest {

    private Household clinic;
    private Household bakery;
    private Household workshop;
    private SolarCooperative cooperative;

    @BeforeEach
    void setUp() {
        clinic = new Household("Clinic", 8, EnergyPriority.ESSENTIAL);
        bakery = new Household("Bakery", 6, EnergyPriority.STANDARD);
        workshop = new Household("Workshop", 10, EnergyPriority.STANDARD);
        cooperative = new SolarCooperative(
            List.of(clinic, bakery, workshop),
            new EqualShareStrategy()
        );
    }

    @Test
    void equalShareStrategySpreadsScarceEnergy() {
        Map<Household, Integer> result = cooperative.distribute(12);

        assertEquals(4, result.get(clinic));
        assertEquals(4, result.get(bakery));
        assertEquals(4, result.get(workshop));
    }

    @Test
    void priorityStrategyFulfillsEssentialDemandFirst() {
        cooperative.setStrategy(new PriorityFirstStrategy());

        Map<Household, Integer> result = cooperative.distribute(12);

        assertEquals(8, result.get(clinic));
        assertEquals(4, result.get(bakery));
        assertEquals(0, result.get(workshop));
    }

    @Test
    void strategiesNeverAllocateBeyondDemand() {
        Map<Household, Integer> result = cooperative.distribute(100);

        assertEquals(8, result.get(clinic));
        assertEquals(6, result.get(bakery));
        assertEquals(10, result.get(workshop));
        assertEquals(24, result.values().stream().mapToInt(Integer::intValue).sum());
    }
}
