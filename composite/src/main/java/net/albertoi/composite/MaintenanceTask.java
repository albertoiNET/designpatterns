package net.albertoi.composite;

import java.util.List;

public class MaintenanceTask implements MaintenanceItem {

    private final String name;
    private final int estimatedMinutes;

    public MaintenanceTask(String name, int estimatedMinutes) {
        if (estimatedMinutes <= 0) {
            throw new IllegalArgumentException("Estimated time must be positive");
        }
        this.name = name;
        this.estimatedMinutes = estimatedMinutes;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int estimatedMinutes() {
        return estimatedMinutes;
    }

    @Override
    public List<String> taskNames() {
        return List.of(name);
    }
}
