package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestProfile(CouchbaseProfile.class)
public class CouchbaseTest {

    @Test
    public void assertMongoIsRunning() {
        assertEquals("couchbase",System.getProperty("db.type"));
    }


    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from CouchbaseImple"));
    }

}