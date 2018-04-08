package net.albertoi.multiton;

import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class Multiton {
    private static Map<MultitonType, Multiton> instances;

    private static final Logger LOGGER = Logger.getLogger(Multiton.class.getName());

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
            LOGGER.info("Instance created");
        }

        if (!instances.containsKey(type)) {
            instances.put(type, new Multiton());

        }
    }

    static Multiton getInstance(MultitonType type) {
        createInstanceIfNeeded(type);
        LOGGER.log(Level.INFO, "Returning instance of type {0}", type);

        return instances.get(type);
    }
}