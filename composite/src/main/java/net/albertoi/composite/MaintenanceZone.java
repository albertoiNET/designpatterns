package net.albertoi.composite;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceZone implements MaintenanceItem {

    private final String name;
    private final List<MaintenanceItem> items = new ArrayList<>();

    public MaintenanceZone(String name) {
        this.name = name;
    }

    public MaintenanceZone add(MaintenanceItem item) {
        items.add(item);
        return this;
    }

    public MaintenanceZone remove(MaintenanceItem item) {
        items.remove(item);
        return this;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int estimatedMinutes() {
        return items.stream()
            .mapToInt(MaintenanceItem::estimatedMinutes)
            .sum();
    }

    @Override
    public List<String> taskNames() {
        return items.stream()
            .flatMap(item -> item.taskNames().stream())
            .toList();
    }
}
