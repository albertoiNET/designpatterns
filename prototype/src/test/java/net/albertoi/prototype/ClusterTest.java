package net.albertoi.prototype;

import net.albertoi.prototype.model.Cluster;
import net.albertoi.prototype.model.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClusterTest {
    private static final String EUR ="EUROPE";
    private Cluster clusterOriginalEurope;


    @Before
    public void setup() {
        //Given
        clusterOriginalEurope = new Cluster("EUR");
        Node nodeOriginalMadrid = new Node("Madrid", 20480);
        Node nodeOriginalRome = new Node("Rome", 40960);
        Node nodeOriginalLondon = new Node("London", 10240);

        clusterOriginalEurope.addNode(nodeOriginalMadrid);
        clusterOriginalEurope.addNode(nodeOriginalRome);
        clusterOriginalEurope.addNode(nodeOriginalLondon);
    }

    @Test
    public void testShallowCopy() {

        // When
        Cluster clusterShallowCopy = clusterOriginalEurope.shallowCopy();

        // Then it seems equals
        Assert.assertEquals(clusterShallowCopy.toString(), clusterOriginalEurope.toString());

        // Changes on deep objects are by reference
        clusterOriginalEurope.getNodes().get(0).setNodeName("Lisbon");

        // So the reference can't change values
        Assert.assertEquals(clusterShallowCopy.getNodes().get(0), clusterOriginalEurope.getNodes().get(0));
        Assert.assertEquals(EUR, clusterShallowCopy.getName());

    }

    @Test
    public void testDeepCopy() {

        //When
        Cluster clusterShallowCopy = clusterOriginalEurope.deepCopy();

        // Then it seems equals
        Assert.assertEquals(clusterShallowCopy.toString(), clusterOriginalEurope.toString());

        // Deep objects are created by calling clone of all child objects
        clusterOriginalEurope.getNodes().get(0).setNodeName("Lisbon");

        // So the value is different
        Assert.assertNotEquals(clusterShallowCopy.getNodes().get(0), clusterOriginalEurope.getNodes().get(0));
        Assert.assertEquals(EUR, clusterShallowCopy.getName());
    }
}
