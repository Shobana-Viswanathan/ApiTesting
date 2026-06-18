package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetStructures extends BaseUrl{
  @Test
  public void getstructure() {
	  String url=get_url();
	  Map<String, Object> payload = new HashMap<>();
		payload.put("email", "sam@gmail.com");
		payload.put("password", "123");
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(payload)
				.when()
				.post(url+"user/login");
		String token = response.jsonPath().getString("token");
	  Response res=RestAssured.given()
			  .header("Authorization" , "Bearer "+ token)
			  .when()
			  .get(url+"courses-structure/getAll ");
	  res.prettyPrint();
	  System.out.println("Status code:"+res.getStatusCode());
	  Assert.assertEquals(res.getStatusCode(), 200);
	  
  }
}
