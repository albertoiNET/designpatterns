package net.albertoi.factorymethod;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConcreteProduct implements Product {

    private static final Logger LOGGER = Logger.getLogger(ConcreteProduct.class.getName());

    @Override
    public void operation() {
        LOGGER.log(Level.INFO, "Operation done by {0}", ConcreteProduct.class.getName());
    }
}
