package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateNote extends BaseUrl {

    @BeforeClass
    public void login() {
        AuthenticationTest authorize = new AuthenticationTest();
        authorize.auth();
    }

    @Test
    public void updateNote() {

        String url = get_url();

        Response getRes = RestAssured
                .given()
                .header("Authorization", "Bearer " + AuthenticationTest.token)
                .when()
                .get(url + "getAll/notes");

        getRes.prettyPrint();

        String noteId = getRes.jsonPath().getString("data[0]._id");

        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "API Test Note (edited)");
        payload.put("content", "Updated content");

        Response updateRes = RestAssured
                .given()
                .header("Authorization", "Bearer " + AuthenticationTest.token)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put(url + "update/notes/" + noteId);

        updateRes.prettyPrint();

        updateRes.then()
                 .statusCode(200);
    }
}