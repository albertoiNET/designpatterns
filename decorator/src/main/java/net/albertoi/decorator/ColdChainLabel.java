package net.albertoi.decorator;

public class ColdChainLabel extends ShippingLabelDecorator {

    private final int maximumTemperature;

    public ColdChainLabel(ShippingLabel wrappedLabel, int maximumTemperature) {
        super(wrappedLabel);
        this.maximumTemperature = maximumTemperature;
    }

    @Override
    public String print() {
        return wrappedLabel.print() + " | Keep below " + maximumTemperature + " C";
    }
}
