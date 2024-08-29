package com.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class BookResourceTest {

    public void testHelloEndpoint(){
        given().when().
                get("/api/book").then().
                statusCode(200).body(is("Hello Quarkus!"));
    }
}
