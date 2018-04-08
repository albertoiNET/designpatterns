package net.albertoi.factorymethod;

public class ConcreteCreator implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }

}
