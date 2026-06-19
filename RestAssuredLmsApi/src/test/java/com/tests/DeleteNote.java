package com.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteNote extends BaseUrl {

    @BeforeClass
    public void login() {

        AuthenticationTest authorize = new AuthenticationTest();
        authorize.auth();
    }

    @Test
    public void deleteNote() {

        String url = get_url();

        Response getRes = RestAssured
                .given()
                .header("Authorization", "Bearer " + AuthenticationTest.token)
                .when()
                .get(url + "getAll/notes");

        getRes.prettyPrint();

        String noteId = getRes.jsonPath().getString("data[0]._id");

        Response deleteRes = RestAssured
                .given()
                .header("Authorization", "Bearer " + AuthenticationTest.token)
                .when()
                .delete(url + "delete/notes/ById/" + noteId);

        deleteRes.prettyPrint();

        deleteRes.then()
                 .statusCode(200);
    }
}