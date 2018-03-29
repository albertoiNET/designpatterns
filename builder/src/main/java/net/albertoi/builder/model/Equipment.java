package net.albertoi.builder.model;

public class Equipment {
    private String name;
    private boolean air;
    private boolean powerWindow;

    public String getName() {
        return name;
    }

    public Equipment setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isAir() {
        return air;
    }

    public Equipment setAir(boolean air) {
        this.air = air;
        return this;
    }

    public boolean isPowerWindow() {
        return powerWindow;
    }

    public Equipment setPowerWindow(boolean powerWindow) {
        this.powerWindow = powerWindow;
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
