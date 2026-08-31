package net.albertoi.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IteratorTest {

    private ObservationLog log;

    @BeforeEach
    void setUp() {
        log = new ObservationLog();
        log.record(new Observation("Vega", "Lyra", 0.03));
        log.record(new Observation("Ring Nebula", "Lyra", 8.8));
        log.record(new Observation("Deneb", "Cygnus", 1.25));
    }

    @Test
    void traversesObservationsInRecordingOrder() {
        List<String> targets = StreamSupport.stream(log.spliterator(), false)
            .map(Observation::target)
            .toList();

        assertEquals(List.of("Vega", "Ring Nebula", "Deneb"), targets);
    }

    @Test
    void filteredIteratorOnlyReturnsBrightTargets() {
        Iterator<Observation> iterator = log.brighterThan(2.0);

        assertEquals("Vega", iterator.next().target());
        assertEquals("Deneb", iterator.next().target());
        assertFalse(iterator.hasNext());
    }

    @Test
    void iteratorsMaintainIndependentTraversalState() {
        Iterator<Observation> first = log.iterator();
        Iterator<Observation> second = log.iterator();

        first.next();
        first.next();

        assertEquals("Vega", second.next().target());
        assertTrue(first.hasNext());
    }

    @Test
    void exhaustedIteratorFollowsTheIteratorContract() {
        Iterator<Observation> iterator = log.brighterThan(-1.0);

        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}
