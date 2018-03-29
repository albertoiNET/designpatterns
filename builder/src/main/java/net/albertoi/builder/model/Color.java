package net.albertoi.builder.model;

public class Color {
    private String name;
    private int hex;

    public String getName() {
        return name;
    }

    public Color setName(String name) {
        this.name = name;
        return this;
    }

    public int getHex() {
        return hex;
    }

    public Color setHex(int hex) {
        this.hex = hex;
        return this;
    }

    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                ", hex=" + hex +
                '}';
    }
}
