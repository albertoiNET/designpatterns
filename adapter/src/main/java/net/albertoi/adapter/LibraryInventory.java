package net.albertoi.adapter;

import java.util.Optional;

public interface LibraryInventory {

    Optional<Book> findByIsbn(String isbn);
}
