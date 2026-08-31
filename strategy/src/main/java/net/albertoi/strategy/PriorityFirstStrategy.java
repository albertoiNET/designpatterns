package net.albertoi.strategy;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PriorityFirstStrategy implements EnergyAllocationStrategy {

    @Override
    public Map<Household, Integer> allocate(
        int availableKwh,
        List<Household> households
    ) {
        Map<Household, Integer> allocations = new LinkedHashMap<>();
        households.forEach(household -> allocations.put(household, 0));

        List<Household> ordered = households.stream()
            .sorted(
                Comparator.comparing(Household::priority)
                    .thenComparing(Household::name)
            )
            .toList();

        int remaining = availableKwh;
        for (Household household : ordered) {
            int granted = Math.min(household.demandKwh(), remaining);
            allocations.put(household, granted);
            remaining -= granted;
        }
        return Map.copyOf(allocations);
    }
}
