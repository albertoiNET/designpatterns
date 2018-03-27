package net.albertoi.prototype.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.albertoi.prototype.factory.Prototype;

@ToString
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
    public Node clone() {
        return new Node(this.nodeName, this.size);
    }

    @Override
    public Node deepClone() {
        return clone();
    }
}