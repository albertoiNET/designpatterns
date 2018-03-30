package net.albertoi.prototype.model;

import lombok.Getter;
import lombok.Setter;
import net.albertoi.prototype.factory.Prototype;

public class Node implements Prototype<Node> {
    @Getter
    @Setter
    private String nodeName;

    @Getter
    @Setter
    private double size;

    public Node(String nodeName, double size) {
        this.nodeName = nodeName;
        this.size = size;
    }

    @Override
    public Node shallowCopy() {
        return new Node(this.nodeName, this.size);
    }

    @Override
    public Node deepCopy() {
        return shallowCopy();
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeName='" + nodeName + '\'' +
                ", size=" + size +
                '}';
    }
}