package com.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Love Next Door", "Korean Author", 2024, "empty"),
                new Book(2, "Alchemy Of Souls", "Korean Author", 2019, "empty"),
                new Book(2, "Marry My Husband", "Korean Author", 2023, "empty"),
                new Book(3, "Queen Of Tears", "Korean Author", 2024, "empty")
        );
    }

    public int countAllBooks() {
        return getAllBooks().size();
    }

    public Optional<Book> getBookById(int id) {
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
