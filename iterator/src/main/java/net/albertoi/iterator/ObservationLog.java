package net.albertoi.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ObservationLog implements Iterable<Observation> {

    private final List<Observation> observations = new ArrayList<>();

    public void record(Observation observation) {
        observations.add(Objects.requireNonNull(observation));
    }

    @Override
    public Iterator<Observation> iterator() {
        return new ChronologicalObservationIterator(List.copyOf(observations));
    }

    public Iterator<Observation> brighterThan(double limitingMagnitude) {
        return new BrightObservationIterator(List.copyOf(observations), limitingMagnitude);
    }
}
