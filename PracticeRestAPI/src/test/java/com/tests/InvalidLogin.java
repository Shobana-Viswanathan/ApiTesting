package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class InvalidLogin {
  @Test
  public void invalidlogin() {
	  Map<String,Object>payload = new HashMap<>();
		
			payload.put("username","admi");
			payload.put("password","admin1");
			
			Response response = RestAssured.given().contentType(ContentType.JSON).body(payload).when().post("http://localhost:5000/login");
			
			System.out.println("Status code:"+response.getStatusCode());
			
			System.out.println(response);
			
			response.prettyPrint();
			
            response.
            then().statusCode(401);		  
  }
}
