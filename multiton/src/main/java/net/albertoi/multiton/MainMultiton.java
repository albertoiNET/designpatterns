package net.albertoi.multiton;

public class MainMultiton {
    // Sample usage
    public static void main(String[] args) {
        Multiton.getInstance(MultitonType.ZERO);
        Multiton.getInstance(MultitonType.ONE);
        Multiton.getInstance(MultitonType.TWO);
    }
}
