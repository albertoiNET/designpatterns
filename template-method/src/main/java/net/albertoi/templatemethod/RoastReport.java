package net.albertoi.templatemethod;

import java.util.List;

public record RoastReport(String roastName, List<String> stages) {

    public RoastReport {
        stages = List.copyOf(stages);
    }
}
