package net.albertoi.observer;

import java.util.ArrayList;
import java.util.List;

public class RiderAvailabilityAlert implements StationObserver {

    private final int minimumBikes;
    private final List<String> messages = new ArrayList<>();

    public RiderAvailabilityAlert(int minimumBikes) {
        if (minimumBikes < 1) {
            throw new IllegalArgumentException("Minimum bikes must be positive");
        }
        this.minimumBikes = minimumBikes;
    }

    @Override
    public void update(StationSnapshot snapshot) {
        if (snapshot.availableBikes() >= minimumBikes) {
            messages.add(
                snapshot.stationName() + " has " + snapshot.availableBikes() + " bikes"
            );
        }
    }

    public List<String> getMessages() {
        return List.copyOf(messages);
    }
}
