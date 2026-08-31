package net.albertoi.observer;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BicycleStation {

    private final String name;
    private final int capacity;
    private final Set<StationObserver> observers = new LinkedHashSet<>();
    private int availableBikes;

    public BicycleStation(String name, int capacity, int availableBikes) {
        if (name == null || name.isBlank() || capacity < 1) {
            throw new IllegalArgumentException("Station details are invalid");
        }
        if (availableBikes < 0 || availableBikes > capacity) {
            throw new IllegalArgumentException("Available bikes exceed station capacity");
        }
        this.name = name;
        this.capacity = capacity;
        this.availableBikes = availableBikes;
    }

    public void subscribe(StationObserver observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    public void unsubscribe(StationObserver observer) {
        observers.remove(observer);
    }

    public void rentBike() {
        if (availableBikes == 0) {
            throw new IllegalStateException("No bicycles are available");
        }
        availableBikes--;
        notifyObservers();
    }

    public void returnBike() {
        if (availableBikes == capacity) {
            throw new IllegalStateException("No empty docks are available");
        }
        availableBikes++;
        notifyObservers();
    }

    public StationSnapshot snapshot() {
        return new StationSnapshot(name, availableBikes, capacity - availableBikes);
    }

    private void notifyObservers() {
        StationSnapshot current = snapshot();
        for (StationObserver observer : List.copyOf(observers)) {
            observer.update(current);
        }
    }
}
