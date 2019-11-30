package net.albertoi.multiton;

import java.util.EnumMap;
import java.util.Map;
import lombok.extern.java.Log;

@Log
class Multiton {

    private static Map<MultitonType, Multiton> instances;

    private Multiton() {
        // Do nothing
    }

    /**
     * Syncronized function for safe-thread
     *
     * @param type What type of multiton instance will be created.
     */
    private static synchronized void createInstanceIfNeeded(MultitonType type) {
        if (instances == null) {
            instances = new EnumMap<>(MultitonType.class);
            log.info("Instance created");
        }

        if (!instances.containsKey(type)) {
            instances.put(type, new Multiton());

        }
    }

    static Multiton getInstance(MultitonType type) {
        createInstanceIfNeeded(type);
        log.info("Returning instance of type " + type);

        return instances.get(type);
    }
}