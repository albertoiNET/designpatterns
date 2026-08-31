package net.albertoi.templatemethod;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TemplateMethodTest {

    @Test
    void templateMethodKeepsTheWorkflowOrder() {
        CoffeeRoastingWorkflow workflow = new LightRoastWorkflow();

        RoastReport report = workflow.roast(new GreenCoffeeBatch("Cauca", 10.8));

        assertEquals(
            List.of(
                "Inspect Cauca",
                "Preheat drum to 190 C",
                "Finish 45 seconds after first crack",
                "Cool with forced air",
                "Rest for 12 hours"
            ),
            report.stages()
        );
    }

    @Test
    void subclassesCustomizeRequiredStepsAndHooks() {
        CoffeeRoastingWorkflow workflow = new DarkRoastWorkflow();

        RoastReport report = workflow.roast(new GreenCoffeeBatch("Sumatra", 11.4));

        assertEquals("Dark roast", report.roastName());
        assertEquals("Develop until the start of second crack", report.stages().get(2));
        assertEquals("Rest for 24 hours", report.stages().get(4));
    }

    @Test
    void sharedInspectionRejectsUnsuitableCoffee() {
        CoffeeRoastingWorkflow workflow = new LightRoastWorkflow();

        assertThrows(
            IllegalArgumentException.class,
            () -> workflow.roast(new GreenCoffeeBatch("Dry lot", 7.5))
        );
    }
}
