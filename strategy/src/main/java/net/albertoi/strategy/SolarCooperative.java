package net.albertoi.strategy;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SolarCooperative {

    private final List<Household> households;
    private EnergyAllocationStrategy strategy;

    public SolarCooperative(
        List<Household> households,
        EnergyAllocationStrategy strategy
    ) {
        this.households = List.copyOf(households);
        this.strategy = Objects.requireNonNull(strategy);
        if (new HashSet<>(this.households).size() != this.households.size()) {
            throw new IllegalArgumentException("Households must be unique");
        }
    }

    public void setStrategy(EnergyAllocationStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy);
    }

    public Map<Household, Integer> distribute(int availableKwh) {
        if (availableKwh < 0) {
            throw new IllegalArgumentException("Available energy cannot be negative");
        }
        return strategy.allocate(availableKwh, households);
    }
}
