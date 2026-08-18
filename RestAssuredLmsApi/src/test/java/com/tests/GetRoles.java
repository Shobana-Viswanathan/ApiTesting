package com.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRoles extends BaseUrl {

    @BeforeClass
    public void login() {

        AuthenticationTest authorize = new AuthenticationTest();
        authorize.auth();
    }

    @Test
    public void getRoles() {

        String url = get_url();

        Response res = RestAssured
                .given()
                .header("Authorization", "Bearer " + AuthenticationTest.token)
                .when()
                .get(url + "roles/getAll");

        res.prettyPrint();

        System.out.println("Status Code: " + res.getStatusCode());

        res.then()
           .statusCode(200);
    }

    @Test
    public void getRoleInvalidToken() {

        String url = get_url();

        Response res = RestAssured
                .given()
                .header("Authorization", "Bearer invalidtoken123")
                .when()
                .get(url + "roles/getAll");

        res.prettyPrint();

        System.out.println("Status Code: " + res.getStatusCode());

        res.then()
           .statusCode(401);
    }

    @Test
    public void getRoleInvalidEndpoint() {

        String url = get_url();

        Response res = RestAssured
                .given()
                .header("Authorization", "Bearer " + AuthenticationTest.token)
                .when()
                .get(url + "roles/getAlll");

        res.prettyPrint();

        System.out.println("Status Code: " + res.getStatusCode());

        res.then()
           .statusCode(404);
    }
}