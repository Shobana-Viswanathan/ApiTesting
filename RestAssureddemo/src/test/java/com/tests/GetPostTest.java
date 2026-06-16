package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetPostTest {
  @Test
  public void getTest() {
	  Response response=RestAssured.given().when().get("https://jsonplaceholder.typicode.com/posts/1");
	  System.out.println("Status Code:"+response.getStatusCode());
	  Assert.assertEquals(response.getStatusCode(), 200);
	  response.prettyPrint();
	 
  }
}
