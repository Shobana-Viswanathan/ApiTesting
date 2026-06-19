package com.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateNotes extends BaseUrl {

    @BeforeClass
    public void login() {

        AuthenticationTest authorize = new AuthenticationTest();
        authorize.auth();
    }

    @Test
    public void create() {

        String url = get_url();

        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "API Test Note");
        payload.put("content", "Created by tester");

        List<String> taglist = new ArrayList<>();
        taglist.add("qa");
        taglist.add("demo");

        payload.put("tags", taglist);
        payload.put("isPinned", false);
        payload.put("color", "#ffeb3b");

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + AuthenticationTest.token)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(url + "create/notes");

        response.prettyPrint();

        System.out.println("Status code: " + response.getStatusCode());

        response.then().statusCode(201);
        Assert.assertEquals(response.jsonPath().getString("message"),
                            "Note created successfully");
    }
}