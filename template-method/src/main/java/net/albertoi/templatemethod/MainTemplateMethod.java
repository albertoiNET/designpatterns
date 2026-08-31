package net.albertoi.templatemethod;

import java.util.logging.Logger;

public class MainTemplateMethod {

    private static final Logger LOGGER =
        Logger.getLogger(MainTemplateMethod.class.getName());

    public static void main(String[] args) {
        CoffeeRoastingWorkflow workflow = new LightRoastWorkflow();
        RoastReport report = workflow.roast(new GreenCoffeeBatch("Cauca", 10.8));
        report.stages().forEach(LOGGER::info);
    }
}
