package net.albertoi.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ChronologicalObservationIterator implements Iterator<Observation> {

    private final List<Observation> observations;
    private int index;

    public ChronologicalObservationIterator(List<Observation> observations) {
        this.observations = List.copyOf(observations);
    }

    @Override
    public boolean hasNext() {
        return index < observations.size();
    }

    @Override
    public Observation next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return observations.get(index++);
    }
}
