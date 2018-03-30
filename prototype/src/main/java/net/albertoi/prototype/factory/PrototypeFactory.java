package net.albertoi.prototype.factory;

import java.util.HashMap;

public class PrototypeFactory {
    private static HashMap<String, Prototype> prototypes = new HashMap<>();

    private PrototypeFactory() {
        //Do nothing
    }

    public static Prototype getPrototype(String prototypeName) {
        return prototypes.get(prototypeName).deepCopy();
    }

    public static void addPrototype(String prototypeName, Prototype prototype) {
        prototypes.put(prototypeName, prototype);
    }
}