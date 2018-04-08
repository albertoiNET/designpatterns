package net.albertoi.multiton;

import org.junit.Assert;
import org.junit.Test;

public class MultitonTest {

    @Test
    public void testGetInstance(){
        Assert.assertNotNull(Multiton.getInstance(MultitonType.TWO));
        Assert.assertNotNull(Multiton.getInstance(MultitonType.TWO));
    }

    @Test
    public void testUniqueInstance(){
        Assert.assertEquals(Multiton.getInstance(MultitonType.ZERO) , Multiton.getInstance(MultitonType.ZERO));
    }

    @Test
    public void testDifferentInstanceType(){
        Assert.assertNotEquals(Multiton.getInstance(MultitonType.ONE) , Multiton.getInstance(MultitonType.ZERO));
    }
}
