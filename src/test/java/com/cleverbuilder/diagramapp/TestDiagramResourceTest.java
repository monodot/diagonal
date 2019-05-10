package com.cleverbuilder.diagramapp;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class TestDiagramResourceTest {

    /**
     * Assert that we can generate a basic diagram.
     * Test implemented using rest-assured
     */
    @Test
    public void testBasicDiagram() {
        given()
                .body("@startuml\n" +
                        "Bob -> Alice: hello\n" +
                        "Alice -> Fred: test message\n" +
                        "@enduml")
                .header("skin", "modern")
                .when().post("/diagram/standard")
                .then()
                    .statusCode(200);
    }

}