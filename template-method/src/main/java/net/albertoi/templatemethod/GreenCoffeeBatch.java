package net.albertoi.templatemethod;

public record GreenCoffeeBatch(String origin, double moisturePercent) {

    public GreenCoffeeBatch {
        if (origin == null || origin.isBlank()) {
            throw new IllegalArgumentException("Coffee origin is required");
        }
    }
}
