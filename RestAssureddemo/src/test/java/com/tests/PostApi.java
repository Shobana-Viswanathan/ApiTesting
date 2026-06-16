package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostApi {
  @Test
  public void getPost() {
	  Response response= RestAssured.given().when().get("https://jsonplaceholder.typicode.com/posts/1/comments");
	  System.out.println("Status Code: "+response.getStatusCode());
	  Assert.assertEquals(response.getStatusCode(), 200);
	  response.prettyPrint();
	  
  }
}
