package net.albertoi.builder;

import lombok.extern.java.Log;
import net.albertoi.builder.builder.CamaroBuilder;
import net.albertoi.builder.builder.CruzeBuilder;
import net.albertoi.builder.model.Chevrolet;

@Log
public class MainBuilder {

    public static void main(String[] args) {
        CarShop carShop = new CarShop();

        carShop.setChevroletBuilder(new CruzeBuilder());
        carShop.construct();
        Chevrolet cruze = carShop.getChevrolet();

        log.info(String.valueOf(cruze));

        carShop.setChevroletBuilder(new CamaroBuilder());
        carShop.construct();
        Chevrolet camaro = carShop.getChevrolet();

        log.info(String.valueOf(camaro));
    }
}
