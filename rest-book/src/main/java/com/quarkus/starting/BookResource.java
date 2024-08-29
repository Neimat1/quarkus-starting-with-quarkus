package com.quarkus.starting;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/book")
public class BookResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "Hello Quarkus!";
    }
}
