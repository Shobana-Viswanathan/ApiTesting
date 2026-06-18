package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginTest extends BaseUrl{
  @Test
  public void login() {
	  String url=get_url();
	  Map<String,Object> payload=new HashMap<>();
	  payload.put("email", "sam@gmail.com");
	  payload.put("password","123");
	  Response response=RestAssured.given()
			  .contentType(ContentType.JSON)
			  .body(payload)
			  .when()
			  .post(url+"user/login");
	  System.out.println("Status code:"+response.getStatusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.getStatusCode(),201);
	  String token = response.jsonPath().getString("token");
	  System.out.println("Token = " + token);
	  
  }
}
		
		
		
