package net.albertoi.singleton;

import org.junit.Assert;
import org.junit.Test;

public class SingletonTest {

    @Test
    public void testGetInstance(){
        Assert.assertNotNull(Singleton.getInstance());
    }
}

