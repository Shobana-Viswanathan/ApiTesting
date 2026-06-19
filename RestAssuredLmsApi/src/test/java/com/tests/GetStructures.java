package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetStructures extends BaseUrl {

    @BeforeClass
    public void login() {
        AuthenticationTest at = new AuthenticationTest();
        at.auth();
    }

    @Test
    public void getstructure() {

        String url = get_url();

        Response res = RestAssured
                .given()
                .header("Authorization", "Bearer " + AuthenticationTest.token)
                .when()
                .get(url + "courses-structure/getAll");

        res.prettyPrint();

        System.out.println("Status code: " + res.getStatusCode());

        Assert.assertEquals(res.getStatusCode(), 200);
    }
}