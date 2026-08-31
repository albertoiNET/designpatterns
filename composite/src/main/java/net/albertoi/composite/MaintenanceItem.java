package net.albertoi.composite;

import java.util.List;

public interface MaintenanceItem {

    String name();

    int estimatedMinutes();

    List<String> taskNames();
}
