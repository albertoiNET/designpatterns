package net.albertoi.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SingletonTest {

    @Test
    void testGetInstance() {
        assertNotNull(Singleton.getInstance());
        assertNotNull(Singleton.getInstance());
    }

    @Test
    void testUniqueInstance() {
        assertSame(Singleton.getInstance(), Singleton.getInstance());
    }
}
