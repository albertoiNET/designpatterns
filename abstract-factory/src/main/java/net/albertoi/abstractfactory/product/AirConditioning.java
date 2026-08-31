package net.albertoi.abstractfactory.product;

public class AirConditioning implements ClimateControl {

    @Override
    public String configure() {
        return "Set quiet air conditioning to 21 C";
    }

    @Override
    public String venueType() {
        return "indoor";
    }
}
