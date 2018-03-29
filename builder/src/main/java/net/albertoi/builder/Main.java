package net.albertoi.builder;

import net.albertoi.builder.builder.CamaroBuilder;
import net.albertoi.builder.builder.CruzeBuilder;
import net.albertoi.builder.model.Chevrolet;

public class Main {

    public static void main(String[] args) {
        CarShop carShop = new CarShop();

        carShop.setChevroletBuilder(new CruzeBuilder());
        carShop.construct();
        Chevrolet cruze = carShop.getChevrolet();

        System.out.println(cruze.toString());

        carShop.setChevroletBuilder(new CamaroBuilder());
        carShop.construct();
        Chevrolet camaro = carShop.getChevrolet();

        System.out.println(camaro.toString());
    }
}
