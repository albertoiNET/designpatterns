package net.albertoi.abstractfactory.product;

public class MistCooling implements ClimateControl {

    @Override
    public String configure() {
        return "Activate low-water mist cooling";
    }

    @Override
    public String venueType() {
        return "outdoor";
    }
}
