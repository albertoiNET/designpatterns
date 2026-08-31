package net.albertoi.abstractfactory;

import java.util.List;

public record EventPlan(String venueType, List<String> instructions) {

    public EventPlan {
        instructions = List.copyOf(instructions);
    }
}
