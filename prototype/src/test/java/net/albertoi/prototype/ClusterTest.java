package net.albertoi.prototype;

import net.albertoi.prototype.model.Cluster;
import net.albertoi.prototype.model.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ClusterTest {
    private static final String EUROPE = "EUROPE";
    private Cluster clusterOriginalEurope;

    @BeforeEach
    void setup() {
        // Given
        clusterOriginalEurope = new Cluster(EUROPE);
        Node nodeOriginalMadrid = new Node("Madrid", 20480);
        Node nodeOriginalRome = new Node("Rome", 40960);
        Node nodeOriginalLondon = new Node("London", 10240);

        clusterOriginalEurope.addNode(nodeOriginalMadrid);
        clusterOriginalEurope.addNode(nodeOriginalRome);
        clusterOriginalEurope.addNode(nodeOriginalLondon);
    }

    @Test
    void testShallowCopy() {

        // When
        Cluster clusterShallowCopy = clusterOriginalEurope.shallowCopy();

        // Then it seems equals
        assertEquals(clusterOriginalEurope.toString(), clusterShallowCopy.toString());

        // Changes on deep objects are by reference
        clusterOriginalEurope.getNodes().get(0).setNodeName("Lisbon");

        // So the reference can't change values
        assertEquals(clusterOriginalEurope.getNodes().get(0), clusterShallowCopy.getNodes().get(0));
        assertEquals(EUROPE, clusterShallowCopy.getName());

    }

    @Test
    void testDeepCopy() {

        // When
        Cluster clusterDeepCopy = clusterOriginalEurope.deepCopy();

        // Then it seems equals
        assertEquals(clusterOriginalEurope.toString(), clusterDeepCopy.toString());

        // Deep objects are created by calling clone of all child objects
        clusterOriginalEurope.getNodes().get(0).setNodeName("Lisbon");

        // So the value is different
        assertNotEquals(clusterOriginalEurope.getNodes().get(0), clusterDeepCopy.getNodes().get(0));
        assertEquals(EUROPE, clusterDeepCopy.getName());
    }
}
