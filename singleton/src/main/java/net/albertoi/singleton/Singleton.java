package net.albertoi.singleton;

import lombok.extern.java.Log;

@Log
class Singleton {

    private static Singleton singleton;

    private Singleton() {
        // Do nothing
    }

    /**
     * Create instance only when is necessary
     */
    private static synchronized void createInstanceIfNeeded() {
        if (singleton == null) {
            singleton = new Singleton();
            log.info("Instance created");
        }
    }

    /**
     * Return always the same instance
     *
     * @return An unique instance of Singleton
     */
    static Singleton getInstance() {
        createInstanceIfNeeded();
        log.info("Returning instance");
        return singleton;
    }
}