package net.albertoi.factorymethod;

public class MainFactoryMethod {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product = creator.factoryMethod();
        product.operation();
    }
}
