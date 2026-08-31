package net.albertoi.composite;

import java.util.logging.Logger;

public class MainComposite {

    private static final Logger LOGGER = Logger.getLogger(MainComposite.class.getName());

    public static void main(String[] args) {
        MaintenanceZone playground = new MaintenanceZone("Playground")
            .add(new MaintenanceTask("Inspect swings", 20))
            .add(new MaintenanceTask("Rake safety surface", 35));

        MaintenanceZone wholePark = new MaintenanceZone("Riverside park")
            .add(playground)
            .add(new MaintenanceTask("Clean drinking fountains", 15));

        LOGGER.info(() -> wholePark.name() + " requires " + wholePark.estimatedMinutes()
            + " minutes for " + wholePark.taskNames());
    }
}
