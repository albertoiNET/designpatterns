package net.albertoi.iterator;

import java.util.Iterator;
import java.util.logging.Logger;

public class MainIterator {

    private static final Logger LOGGER = Logger.getLogger(MainIterator.class.getName());

    public static void main(String[] args) {
        ObservationLog log = new ObservationLog();
        log.record(new Observation("Vega", "Lyra", 0.03));
        log.record(new Observation("Ring Nebula", "Lyra", 8.8));
        log.record(new Observation("Deneb", "Cygnus", 1.25));

        Iterator<Observation> visibleTargets = log.brighterThan(2.0);
        visibleTargets.forEachRemaining(
            observation -> LOGGER.info(observation::target)
        );
    }
}
