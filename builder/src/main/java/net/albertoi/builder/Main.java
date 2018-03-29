package net.albertoi.builder;

import net.albertoi.builder.builder.CamaroBuilder;
import net.albertoi.builder.builder.CruzeBuilder;
import net.albertoi.builder.model.Chevrolet;

import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        CarShop carShop = new CarShop();

        carShop.setChevroletBuilder(new CruzeBuilder());
        carShop.construct();
        Chevrolet cruze = carShop.getChevrolet();

        LOGGER.info(cruze.toString());

        carShop.setChevroletBuilder(new CamaroBuilder());
        carShop.construct();
        Chevrolet camaro = carShop.getChevrolet();

        LOGGER.info(camaro.toString());
    }
}
