package net.albertoi.decorator;

import java.util.logging.Logger;

public class MainDecorator {

    private static final Logger LOGGER = Logger.getLogger(MainDecorator.class.getName());

    public static void main(String[] args) {
        ShippingLabel label = new BasicShippingLabel("Coastal Lab", "Pier 4");
        label = new TrackingLabel(label, "BIO-2048");
        label = new ColdChainLabel(label, 4);

        ShippingLabel decoratedLabel = label;
        LOGGER.info(decoratedLabel::print);
    }
}
