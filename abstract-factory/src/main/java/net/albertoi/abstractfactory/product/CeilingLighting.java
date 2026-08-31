package net.albertoi.abstractfactory.product;

public class CeilingLighting implements Lighting {

    @Override
    public String install() {
        return "Calibrate dimmable ceiling lights";
    }

    @Override
    public String venueType() {
        return "indoor";
    }
}
