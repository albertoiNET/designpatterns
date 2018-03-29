package net.albertoi.builder.model;

public class Model {
    private String name;
    private int year;
    private char segment;
    private boolean gasoline;

    public String getName() {
        return name;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Model setYear(int year) {
        this.year = year;
        return this;
    }

    public char getSegment() {
        return segment;
    }

    public Model setSegment(char segment) {
        this.segment = segment;
        return this;
    }

    public boolean isGasoline() {
        return gasoline;
    }

    public Model setGasoline(boolean gasoline) {
        this.gasoline = gasoline;
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
