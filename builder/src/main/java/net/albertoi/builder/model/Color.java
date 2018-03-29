package net.albertoi.builder.model;

public class Color {
    private String name;
    private int hex;

    public Color setName(String name) {
        this.name = name;
        return this;
    }

    public Color setHex(int hex) {
        this.hex = hex;
        return this;
    }

    public Color build() {
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
