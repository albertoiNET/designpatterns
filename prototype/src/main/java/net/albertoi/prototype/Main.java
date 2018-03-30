package net.albertoi.prototype;

import net.albertoi.prototype.factory.PrototypeFactory;
import net.albertoi.prototype.model.Cluster;
import net.albertoi.prototype.model.Node;

import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {
        final String miniClusterLabel = "Min cluster List";
        final String mediumClusterLabel = "Med cluster List";
        final String bigClusterLabel = "Big cluster List";


        Cluster sizeSCluster = new Cluster(miniClusterLabel);
        for (int c = 1; c <= 5; c++) {
            Node nodeSizeS = new Node("Node " + c, c * 1024);
            sizeSCluster.addNode(nodeSizeS);
        }
        PrototypeFactory.addPrototype(sizeSCluster.getName(), sizeSCluster);

        Cluster sizeMCluster = (Cluster) PrototypeFactory.getPrototype(sizeSCluster.getName());
        sizeMCluster.setName(mediumClusterLabel);
        for (Node nodeSizeM : sizeMCluster.getNodes()) {
            nodeSizeM.setSize(nodeSizeM.getSize() * 2);
        }
        PrototypeFactory.addPrototype(sizeMCluster.getName(), sizeMCluster);


        Cluster sizeLCluster = (Cluster) PrototypeFactory.getPrototype(sizeMCluster.getName());
        sizeLCluster.setName(bigClusterLabel);
        for (Node nodeSizeL : sizeLCluster.getNodes()) {
            nodeSizeL.setSize(nodeSizeL.getSize() * 2);
        }
        PrototypeFactory.addPrototype(sizeLCluster.getName(), sizeLCluster);

        LOGGER.info(PrototypeFactory.getPrototype(miniClusterLabel)::toString);
        LOGGER.info(PrototypeFactory.getPrototype(mediumClusterLabel)::toString);
        LOGGER.info(PrototypeFactory.getPrototype(bigClusterLabel)::toString);

    }

}
