package net.albertoi.templatemethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class CoffeeRoastingWorkflow {

    public final RoastReport roast(GreenCoffeeBatch batch) {
        GreenCoffeeBatch inspectedBatch = Objects.requireNonNull(batch);
        inspect(inspectedBatch);

        List<String> stages = new ArrayList<>();
        stages.add("Inspect " + inspectedBatch.origin());
        stages.add("Preheat drum to " + preheatTemperature() + " C");
        stages.add(applyHeat(inspectedBatch));
        stages.add("Cool with forced air");
        stages.add("Rest for " + restingHours() + " hours");
        return new RoastReport(roastName(), stages);
    }

    protected void inspect(GreenCoffeeBatch batch) {
        if (batch.moisturePercent() < 9.0 || batch.moisturePercent() > 13.0) {
            throw new IllegalArgumentException("Coffee moisture is outside roasting range");
        }
    }

    protected int preheatTemperature() {
        return 190;
    }

    protected abstract String applyHeat(GreenCoffeeBatch batch);

    protected abstract String roastName();

    protected int restingHours() {
        return 12;
    }
}
