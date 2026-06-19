package com.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ToggleTest extends BaseUrl {

    @BeforeClass
    public void login() {
        AuthenticationTest authorize = new AuthenticationTest();
        authorize.auth();
    }

    @Test
    public void togglePin() {

        String url = get_url();

        Response getRes = RestAssured
                .given()
                .header("Authorization", "Bearer " + AuthenticationTest.token)
                .when()
                .get(url + "getAll/notes");

        getRes.prettyPrint();

        String noteId = getRes.jsonPath().getString("data[0]._id");

        Response toggleRes = RestAssured
                .given()
                .header("Authorization", "Bearer " + AuthenticationTest.token)
                .when()
                .put(url + "toggle-pin/notes/" + noteId);

        toggleRes.prettyPrint();

        toggleRes.then()
                 .statusCode(200);
    }
}