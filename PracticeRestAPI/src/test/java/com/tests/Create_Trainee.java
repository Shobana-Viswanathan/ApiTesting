package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create_Trainee {
  @Test
  public void createTrainee() {
	  Map<String,Object> payload= new HashMap();
	  payload.put("name", "yadav");
	  payload.put("email", "yadav1@gmail.com");
	  payload.put("company","hcl");
	  Response response=RestAssured.given().contentType(ContentType.JSON).body(payload).when().post("http://localhost:3000/trainees");
	  System.out.println("Status code:"+response.getStatusCode());
	  response.prettyPrint();
	  response.then()
	  .statusCode(201);
  }
  
}
