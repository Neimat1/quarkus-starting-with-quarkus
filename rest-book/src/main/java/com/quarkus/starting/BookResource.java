package com.quarkus.starting;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository repository;

    @Inject
    Logger logger;  //using Jboss one if you tried to import from others will fail

    @GET
    public List<Book> getAllBooks() {
        logger.info("Get all books");
        return repository.getAllBooks();
    }


    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        logger.info("Count all books");
        return repository.countAllBooks();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Book> getBookById(@PathParam("id") int id) {
        logger.info("Get book by id: " + id);
        return repository.getBookById(id);
    }
}
