package org.acme;

import io.quarkus.test.junit.QuarkusTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import io.quarkus.test.junit.TestProfile;



@QuarkusTest
@TestProfile(MongoProfile.class)
public class MongoTest {

    @Test
    public void assertMongoIsRunning() {
        assertEquals("mongo",System.getProperty("db.type"));
    }

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from MongoImple"));
    }

}