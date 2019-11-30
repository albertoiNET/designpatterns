package net.albertoi.factorymethod;

import lombok.extern.java.Log;


@Log
public class ConcreteProduct implements Product {


    @Override
    public void operation() {

        log.info("Operation done by " + ConcreteProduct.class.getName());

    }
}
