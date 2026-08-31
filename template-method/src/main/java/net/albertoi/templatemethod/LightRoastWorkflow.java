package net.albertoi.templatemethod;

public class LightRoastWorkflow extends CoffeeRoastingWorkflow {

    @Override
    protected String applyHeat(GreenCoffeeBatch batch) {
        return "Finish 45 seconds after first crack";
    }

    @Override
    protected String roastName() {
        return "Light roast";
    }
}
