package com.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TraceTest {

    @Test
    public void traceRequest() {

        Response response = RestAssured
                .given()
                .when()
                .request("TRACE", "https://jsonplaceholder.typicode.com/posts");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println(response.asString());
    }
}