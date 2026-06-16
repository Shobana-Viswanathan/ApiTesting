package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete_Trainee {
  @Test
  public void deletetrainee() {
	  Response response=RestAssured.given().when().delete("http://localhost:3000/trainees/nBVXQIBWwhg");
	  System.out.println("Status code:"+response.getStatusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.getStatusCode(), 200);
  }
}
