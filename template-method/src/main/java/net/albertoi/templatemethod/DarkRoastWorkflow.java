package net.albertoi.templatemethod;

public class DarkRoastWorkflow extends CoffeeRoastingWorkflow {

    @Override
    protected String applyHeat(GreenCoffeeBatch batch) {
        return "Develop until the start of second crack";
    }

    @Override
    protected String roastName() {
        return "Dark roast";
    }

    @Override
    protected int restingHours() {
        return 24;
    }
}
