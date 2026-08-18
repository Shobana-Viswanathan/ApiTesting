package com.tests;

import java.util.HashMap;
import java.util.Map;

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
                .when()
                .get(url + "getAll/notes");

        response.prettyPrint();

        System.out.println("Status Code: " + response.getStatusCode());

        response.then()
                .statusCode(200);
    }

    @Test
    public void valid_withqparam1() {

        Map<String, Object> queryParams = new HashMap<>();

        queryParams.put("page", 1);
        queryParams.put("limit", 50);
        queryParams.put("search", "Test");
        queryParams.put("tags", "[qa]");
        queryParams.put("isPinned", true);
        queryParams.put("sortBy", "lastEdited");
        queryParams.put("sortOrder", "asc");

        String url = get_url();

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + AuthenticationTest.token)
                .queryParams(queryParams)
                .when()
                .get(url + "getAll/notes");

        response.prettyPrint();

        System.out.println("Status Code: " + response.getStatusCode());

        response.then()
                .statusCode(200);
    }

    @Test
    public void valid_withqparam2() {

        Map<String, Object> queryParams = new HashMap<>();

        queryParams.put("page", 1);
        queryParams.put("limit", 50);
        queryParams.put("search", "Test");
        queryParams.put("tags", "[qa,demo]");
        queryParams.put("isPinned", false);
        queryParams.put("sortBy", "title");
        queryParams.put("sortOrder", "desc");

        String url = get_url();

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + AuthenticationTest.token)
                .queryParams(queryParams)
                .when()
                .get(url + "getAll/notes");

        response.prettyPrint();

        System.out.println("Status Code: " + response.getStatusCode());

        response.then()
                .statusCode(200);
    }
}