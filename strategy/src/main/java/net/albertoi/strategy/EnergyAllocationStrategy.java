package net.albertoi.strategy;

import java.util.List;
import java.util.Map;

public interface EnergyAllocationStrategy {

    Map<Household, Integer> allocate(int availableKwh, List<Household> households);
}
