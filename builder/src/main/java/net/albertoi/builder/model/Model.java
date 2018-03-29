package net.albertoi.builder.model;

public class Model {
    private String name;
    private int year;
    private char segment;
    private boolean gasoline;

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    public Model setYear(int year) {
        this.year = year;
        return this;
    }

    public Model setSegment(char segment) {
        this.segment = segment;
        return this;
    }

    public Model setGasoline(boolean gasoline) {
        this.gasoline = gasoline;
        return this;
    }

    public Model build() {
        return this;
    }


    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", segment=" + segment +
                ", gasoline=" + gasoline +
                '}';
    }
}
