package net.albertoi.adapter;

import java.util.Map;

public class LegacyBookRegistry {

    private final Map<String, String> records = Map.of(
        "978-0-13-235088-4", "978-0-13-235088-4|Clean Code|3",
        "978-0-201-63361-0", "978-0-201-63361-0|Design Patterns|1"
    );

    public String lookupRawRecord(String isbn) {
        return records.get(isbn);
    }
}
