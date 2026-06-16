package com.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConnectTest {

    @Test
    public void connectRequest() {

        Response response = RestAssured
                .given()
                .when()
                .request("CONNECT", "https://jsonplaceholder.typicode.com/posts");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println(response.asString());
    }
}