package net.albertoi.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BrightObservationIterator implements Iterator<Observation> {

    private final List<Observation> observations;
    private final double limitingMagnitude;
    private int index;
    private Observation next;

    public BrightObservationIterator(
        List<Observation> observations,
        double limitingMagnitude
    ) {
        this.observations = List.copyOf(observations);
        this.limitingMagnitude = limitingMagnitude;
        advance();
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Observation next() {
        if (next == null) {
            throw new NoSuchElementException();
        }
        Observation current = next;
        advance();
        return current;
    }

    private void advance() {
        next = null;
        while (index < observations.size() && next == null) {
            Observation candidate = observations.get(index++);
            if (candidate.magnitude() <= limitingMagnitude) {
                next = candidate;
            }
        }
    }
}
