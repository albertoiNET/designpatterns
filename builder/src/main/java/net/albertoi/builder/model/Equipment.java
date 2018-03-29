package net.albertoi.builder.model;

public class Equipment {
    private String name;
    private boolean air;
    private boolean powerWindow;

    public Equipment setName(String name) {
        this.name = name;
        return this;
    }

    public Equipment setAir(boolean air) {
        this.air = air;
        return this;
    }

    public Equipment setPowerWindow(boolean powerWindow) {
        this.powerWindow = powerWindow;
        return this;
    }

    public Equipment build() {
        return this;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                ", air=" + air +
                ", powerWindow=" + powerWindow +
                '}';
    }
}
