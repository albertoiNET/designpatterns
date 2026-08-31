package net.albertoi.strategy;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class MainStrategy {

    private static final Logger LOGGER = Logger.getLogger(MainStrategy.class.getName());

    public static void main(String[] args) {
        Household clinic = new Household("Community clinic", 8, EnergyPriority.ESSENTIAL);
        Household workshop = new Household("Repair workshop", 8, EnergyPriority.STANDARD);
        SolarCooperative cooperative =
            new SolarCooperative(List.of(clinic, workshop), new EqualShareStrategy());

        Map<Household, Integer> allocation = cooperative.distribute(10);
        LOGGER.info(() -> "Clinic allocation: " + allocation.get(clinic) + " kWh");
    }
}
