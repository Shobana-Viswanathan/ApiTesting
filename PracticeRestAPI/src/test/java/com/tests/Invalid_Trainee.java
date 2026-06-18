package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import io.restassured.RestAssured;

public class Invalid_Trainee {
  @Test
  public void invalidtrainee() {
	  Response response=RestAssured.given().when().get("http://localhost:3000/trainees/1");
      System.out.println("Status code:"+response.getStatusCode());
      response
      .then().statusCode(404);	  
	  
  }
}
