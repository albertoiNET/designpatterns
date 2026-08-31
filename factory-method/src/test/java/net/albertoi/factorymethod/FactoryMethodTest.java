package net.albertoi.factorymethod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FactoryMethodTest {
    private Creator creator;

    @BeforeEach
    void setup() {
        creator = new ConcreteCreator();
    }

    @Test
    void testFactoryMethod() {
        assertNotNull(creator);
        assertInstanceOf(ConcreteCreator.class, creator);

        Product product = creator.factoryMethod();
        assertInstanceOf(ConcreteProduct.class, product);
        product.operation();
    }
}
