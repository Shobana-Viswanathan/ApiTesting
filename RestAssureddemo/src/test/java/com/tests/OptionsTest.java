package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OptionsTest {

    @Test
    public void optionsRequest() {

        Response response = RestAssured
                .given()
                .when()
                .options("https://jsonplaceholder.typicode.com");

        System.out.println("Status Code: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 204);
    }
}