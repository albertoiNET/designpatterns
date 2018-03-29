package net.albertoi.builder.builder;

import net.albertoi.builder.model.Chevrolet;

public class CruzeBuilder extends ChevroletBuilder {


    public CruzeBuilder() {
        super.chevrolet = new Chevrolet("Cruze");
    }

    @Override
    public void buildModel() {
        chevrolet.getModel().setYear(2011).setGasoline(true).setSegment('C');
    }

    @Override
    public void buildEquipment() {
        chevrolet.getEquipment().setName("Basic").setAir(true).setPowerWindow(true);
    }

    @Override
    public void buildColor() {
        chevrolet.getColor().setName("Red").setHex(0xEF3340);
    }
}
