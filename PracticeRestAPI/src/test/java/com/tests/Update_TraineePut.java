package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Update_TraineePut {
  @Test
  public void updateput() {
	  Map<String,Object> payload= new HashMap();
	  payload.put("name", "vikram");
	  payload.put("email", "vikram1@gmail.com");
	  payload.put("company","medex");
	  payload.put("id",29);
	  Response response=RestAssured.given().contentType(ContentType.JSON).body(payload).when().put("http://localhost:3000/trainees/29");
	  System.out.println("Status code:"+response.getStatusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.jsonPath().getString("name"),"vikram");  }
}
