package net.albertoi.observer;

import java.util.logging.Logger;

public class MainObserver {

    private static final Logger LOGGER = Logger.getLogger(MainObserver.class.getName());

    public static void main(String[] args) {
        BicycleStation station = new BicycleStation("Market Square", 12, 2);
        RiderAvailabilityAlert alert = new RiderAvailabilityAlert(3);
        station.subscribe(alert);

        station.returnBike();
        LOGGER.info(() -> alert.getMessages().get(0));
    }
}
