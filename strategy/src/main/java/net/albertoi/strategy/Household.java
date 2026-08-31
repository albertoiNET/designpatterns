package net.albertoi.strategy;

import java.util.Objects;

public record Household(String name, int demandKwh, EnergyPriority priority) {

    public Household {
        if (name == null || name.isBlank() || demandKwh < 0) {
            throw new IllegalArgumentException("Household details are invalid");
        }
        Objects.requireNonNull(priority);
    }
}
