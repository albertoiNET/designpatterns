package net.albertoi.singleton;

import java.util.logging.Logger;

class Singleton {
    private static Singleton singleton;

    private static final Logger LOGGER = Logger.getLogger(Singleton.class.getName());


    private Singleton() {
        // Do nothing
    }

    /**
     * Create instance only when is necessary
     */
    private static synchronized void createInstanceIfNeeded() {
        if (singleton == null) {
            singleton = new Singleton();
            LOGGER.info("Instance created");
        }
    }

    /**
     * Return always the same instance
     *
     * @return An unique instance of Singleton
     */
    static Singleton getInstance() {
        createInstanceIfNeeded();
        LOGGER.info("Returning instance");
        return singleton;
    }
}