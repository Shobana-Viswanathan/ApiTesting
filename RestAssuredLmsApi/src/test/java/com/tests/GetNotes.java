package com.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetNotes extends BaseUrl {

    @BeforeClass
    public void login() {

        AuthenticationTest authorize = new AuthenticationTest();
        authorize.auth();
    }

    @Test
    public void getAllNotes() {

        String url = get_url();

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + AuthenticationTest.token)
                .get(url + "getAll/notes");
              

        response.prettyPrint();

        response.then()
                .statusCode(200);

    }
}