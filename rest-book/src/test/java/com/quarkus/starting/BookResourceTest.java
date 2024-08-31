package com.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void testGetAllBooksEndpoint() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when().get("/api/books")
                .then().statusCode(200).body("size()", is(4));
    }

    @Test
    public void testCountAllBooksEndpoint() {
        given().header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
                .when().get("/api/books/count")
                .then().statusCode(200).body(is("4"));
    }


    @Test
    public void testGetBookByIdEndpoint() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).pathParam("id", 1)
                .when().get("/api/books/{id}")
                .then().statusCode(200).body("title", is("Love Next Door")).body("genre", is("Korean Drama"));
    }

}
