package net.albertoi.multiton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

public class MultitonTest {

    @Test
    void testGetInstance() {
        assertNotNull(Multiton.getInstance(MultitonType.TWO));
        assertNotNull(Multiton.getInstance(MultitonType.TWO));
    }

    @Test
    void testUniqueInstance() {
        assertSame(Multiton.getInstance(MultitonType.ZERO), Multiton.getInstance(MultitonType.ZERO));
    }

    @Test
    void testDifferentInstanceType() {
        assertNotSame(Multiton.getInstance(MultitonType.ONE), Multiton.getInstance(MultitonType.ZERO));
    }
}
