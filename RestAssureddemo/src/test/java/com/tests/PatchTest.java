package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PatchTest {

    @Test
    public void patchToUpdatePartially() {

        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "New patch title");

        Response response = RestAssured .given().contentType(ContentType.JSON).body(payload).pathParam("id", 1).when().patch("https://jsonplaceholder.typicode.com/posts/{id}");

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);

        String actualTitle = response.jsonPath().getString("title");
        Assert.assertEquals(actualTitle, "New patch title");
    }
}