package net.albertoi.adapter;

import java.util.Optional;

public class LegacyBookRegistryAdapter implements LibraryInventory {

    private final LegacyBookRegistry legacyRegistry;

    public LegacyBookRegistryAdapter(LegacyBookRegistry legacyRegistry) {
        this.legacyRegistry = legacyRegistry;
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        String rawRecord = legacyRegistry.lookupRawRecord(isbn);
        if (rawRecord == null) {
            return Optional.empty();
        }

        String[] fields = rawRecord.split("\\|");
        if (fields.length != 3) {
            throw new IllegalStateException("Unexpected legacy book record: " + rawRecord);
        }

        return Optional.of(new Book(fields[0], fields[1], Integer.parseInt(fields[2])));
    }
}
