package net.albertoi.iterator;

public record Observation(String target, String constellation, double magnitude) {

    public Observation {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException("A target is required");
        }
        if (constellation == null || constellation.isBlank()) {
            throw new IllegalArgumentException("A constellation is required");
        }
    }
}
