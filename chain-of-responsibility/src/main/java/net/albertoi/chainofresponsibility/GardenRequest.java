package net.albertoi.chainofresponsibility;

public record GardenRequest(String description, int volunteerHours, int cost) {

    public GardenRequest {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("A description is required");
        }
        if (volunteerHours < 0 || cost < 0) {
            throw new IllegalArgumentException("Hours and cost cannot be negative");
        }
    }
}
