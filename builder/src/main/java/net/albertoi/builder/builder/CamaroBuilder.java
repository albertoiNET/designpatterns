package net.albertoi.builder.builder;

import net.albertoi.builder.model.Chevrolet;

public class CamaroBuilder extends ChevroletBuilder {


    public CamaroBuilder() {
        super.chevrolet = new Chevrolet("Camaro");
    }

    @Override
    public void buildModel() {
        chevrolet.getModel().setName("GT").setYear(2018).setGasoline(true).setSegment('B');
    }

    @Override
    public void buildColor() {
        chevrolet.getColor().setName("Yellow").setHex(0xC8F945);
    }

    @Override
    public void buildEquipment() {
        chevrolet.getEquipment().setName("Full").setAir(true).setPowerWindow(true);
    }

}
