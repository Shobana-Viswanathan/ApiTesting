package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_Trainee {
  @Test
  public void getUserTest() {

      Response response = RestAssured
              .given()
              .when()
              .get("http://localhost:3000/trainees/11");
      response.then().statusCode(200);
	  Assert.assertEquals(response.jsonPath().getString("company"),"expleo");
      response.prettyPrint();

  }
}
