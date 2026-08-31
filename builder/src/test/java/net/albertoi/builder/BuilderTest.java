package net.albertoi.builder;

import net.albertoi.builder.builder.CamaroBuilder;
import net.albertoi.builder.builder.CruzeBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BuilderTest {

    private CarShop carShop;

    @BeforeEach
    void setup() {
        carShop = new CarShop();
    }

    @Test
    void testConstructCruze() {
        // Given
        carShop.setChevroletBuilder(new CruzeBuilder());

        // When
        carShop.construct();

        // Then
        assertNotNull(carShop.getChevrolet().toString());
        assertEquals("Cruze", carShop.getChevrolet().getName());
    }

    @Test
    void testConstructCamaro() {
        // Given
        carShop.setChevroletBuilder(new CamaroBuilder());

        // When
        carShop.construct();

        // Then
        assertNotNull(carShop.getChevrolet().toString());
        assertEquals("Camaro", carShop.getChevrolet().getName());
    }
}
