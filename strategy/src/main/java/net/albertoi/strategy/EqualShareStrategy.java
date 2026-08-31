package net.albertoi.strategy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EqualShareStrategy implements EnergyAllocationStrategy {

    @Override
    public Map<Household, Integer> allocate(
        int availableKwh,
        List<Household> households
    ) {
        Map<Household, Integer> allocations = emptyAllocations(households);
        List<Household> active = new ArrayList<>(households);
        int remaining = availableKwh;

        while (remaining > 0 && !active.isEmpty()) {
            int share = Math.max(1, remaining / active.size());
            for (Household household : List.copyOf(active)) {
                int need = household.demandKwh() - allocations.get(household);
                int granted = Math.min(Math.min(need, share), remaining);
                allocations.put(household, allocations.get(household) + granted);
                remaining -= granted;
                if (allocations.get(household) == household.demandKwh()) {
                    active.remove(household);
                }
                if (remaining == 0) {
                    break;
                }
            }
        }
        return Map.copyOf(allocations);
    }

    private Map<Household, Integer> emptyAllocations(List<Household> households) {
        Map<Household, Integer> allocations = new LinkedHashMap<>();
        for (Household household : households) {
            allocations.put(household, 0);
        }
        return allocations;
    }
}
