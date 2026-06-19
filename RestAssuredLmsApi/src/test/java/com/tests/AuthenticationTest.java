package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AuthenticationTest extends BaseUrl {

    public static String token;

    @Test
    public String auth() {

        String url = get_url();

        Map<String, Object> payload = new HashMap<>();
        payload.put("Role", "Admin");
        payload.put("email", "sam@gmail.com");
        payload.put("password", "123");

        Response res = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(url + "user/login");

        token = res.jsonPath().getString("token");

        return token;
    }
}