package net.albertoi.builder;

import net.albertoi.builder.builder.ChevroletBuilder;
import net.albertoi.builder.model.Chevrolet;

import java.util.logging.Logger;

class CarShop {

    private ChevroletBuilder chevroletBuilder;

    private static final Logger LOGGER = Logger.getLogger(CarShop.class.getName());


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
        LOGGER.info("Constructed car");
    }

}
