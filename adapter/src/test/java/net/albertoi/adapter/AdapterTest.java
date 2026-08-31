package net.albertoi.adapter;

import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdapterTest {

    private LibraryInventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new LegacyBookRegistryAdapter(new LegacyBookRegistry());
    }

    @Test
    void convertsTheLegacyRecordIntoTheExpectedDomainObject() {
        Optional<Book> result = inventory.findByIsbn("978-0-13-235088-4");

        assertTrue(result.isPresent());
        assertEquals("Clean Code", result.orElseThrow().title());
        assertEquals(3, result.orElseThrow().availableCopies());
    }

    @Test
    void preservesTheNewInterfaceMissingBookContract() {
        assertTrue(inventory.findByIsbn("unknown").isEmpty());
    }
}
