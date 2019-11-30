package net.albertoi.factorymethod;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FactoryMethodTest {
    private Creator creator;

    @Before
    public void setup() {
        creator = new ConcreteCreator();
    }

    @Test
    public void testFactoryMethod() {
        Assert.assertNotNull(creator);
        Assert.assertTrue(creator instanceof ConcreteCreator);

        Object object = creator.factoryMethod();
        Assert.assertFalse(object instanceof ConcreteCreator);
        Assert.assertTrue(object instanceof ConcreteProduct);

        ((Product) object).operation();
    }
}
