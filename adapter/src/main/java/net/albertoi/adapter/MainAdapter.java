package net.albertoi.adapter;

import java.util.logging.Logger;

public class MainAdapter {

    private static final Logger LOGGER = Logger.getLogger(MainAdapter.class.getName());

    public static void main(String[] args) {
        LibraryInventory inventory = new LegacyBookRegistryAdapter(new LegacyBookRegistry());

        inventory.findByIsbn("978-0-13-235088-4")
            .ifPresent(book -> LOGGER.info(() -> book.title() + ": " + book.availableCopies() + " copies"));
    }
}
