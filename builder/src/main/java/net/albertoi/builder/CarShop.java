package net.albertoi.builder;

import lombok.extern.java.Log;
import net.albertoi.builder.builder.ChevroletBuilder;
import net.albertoi.builder.model.Chevrolet;

@Log
class CarShop {

    private ChevroletBuilder chevroletBuilder;


    void setChevroletBuilder(ChevroletBuilder chevroletBuilder) {
        this.chevroletBuilder = chevroletBuilder;
    }

    Chevrolet getChevrolet() {
        return chevroletBuilder.getChevrolet();
    }

    void construct() {
        chevroletBuilder.buildModel();
        chevroletBuilder.buildEquipment();
        chevroletBuilder.buildColor();
      log.info("Constructed car");
    }

}
