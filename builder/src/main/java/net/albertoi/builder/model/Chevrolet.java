package net.albertoi.builder.model;

public class Chevrolet {
    private String name;
    private Color color;
    private Model model;
    private Equipment equipment;

    public Chevrolet(String name) {
        this.name = name;
        this.model = new Model();
        this.equipment = new Equipment();
        this.color = new Color();
    }

    public String getName() {
        return name;
    }

    public Model getModel() {
        return model;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Color getColor() {
        return color;
    }


    @Override
    public String toString() {
        return "Chevrolet{" + name + ", " + color + ", " + model + ", " + equipment + '}';
    }
}
