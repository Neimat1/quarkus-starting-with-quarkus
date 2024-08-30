package com.quarkus.starting;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @GET
    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Love Next Door", "Korean Author", 2024, "empty"),
                new Book(2, "Alchemy Of Souls", "Korean Author", 2019, "empty"),
                new Book(2, "Marry My Husband", "Korean Author", 2023, "empty"),
                new Book(3, "Queen Of Tears", "Korean Author", 2024, "empty")
        );
    }


    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        return getAllBooks().size();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Book> getBookById(@PathParam("id") int id) {
        return getAllBooks().stream().filter(book -> book.id==id).findFirst();
    }
}
