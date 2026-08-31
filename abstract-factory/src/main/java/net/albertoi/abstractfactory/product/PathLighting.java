package net.albertoi.abstractfactory.product;

public class PathLighting implements Lighting {

    @Override
    public String install() {
        return "Position solar lights along every path";
    }

    @Override
    public String venueType() {
        return "outdoor";
    }
}
