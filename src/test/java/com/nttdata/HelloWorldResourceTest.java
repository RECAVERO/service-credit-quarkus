package com.nttdata;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class HelloWorldResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello-world")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }

}