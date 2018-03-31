package net.albertoi.builder;

import net.albertoi.builder.builder.CamaroBuilder;
import net.albertoi.builder.builder.CruzeBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BuilderTest {

    private CarShop carShop;

    @Before
    public void setup(){
        carShop = new CarShop();
    }

    @Test
    public void testConstructCruze(){
        // Given
        carShop.setChevroletBuilder(new CruzeBuilder());

        // When
        carShop.construct();

        // Then
        Assert.assertNotNull(carShop.getChevrolet().toString());
        Assert.assertEquals(carShop.getChevrolet().getName(), "Cruze");
    }

    @Test
    public void testConstructCamaro(){
        // Given
        carShop.setChevroletBuilder(new CamaroBuilder());

        // When
        carShop.construct();

        // Then
        Assert.assertNotNull(carShop.getChevrolet().toString());
        Assert.assertEquals(carShop.getChevrolet().getName(), "Camaro");
    }
}
