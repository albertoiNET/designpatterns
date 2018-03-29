package net.albertoi.builder.builder;

import net.albertoi.builder.model.Chevrolet;

public abstract class ChevroletBuilder {
    Chevrolet chevrolet;

    public Chevrolet getChevrolet() {
        return chevrolet;
    }

    public abstract void buildModel();

    public abstract void buildEquipment();

    public abstract void buildColor();

}
