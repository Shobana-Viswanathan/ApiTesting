package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTest {
  @Test
  public void todelete() {
	  Response response=RestAssured.given().when().delete("https://jsonplaceholder.typicode.com/posts/1");
	  response.prettyPrint();
	  System.out.println("Status code:"+response.getStatusCode());
	  Assert.assertEquals(response.getStatusCode(), 200);
	  
  }
}
