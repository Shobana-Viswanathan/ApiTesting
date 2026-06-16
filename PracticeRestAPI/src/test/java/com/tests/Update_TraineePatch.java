package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Update_TraineePatch {
  @Test
  public void updatepatch() {
	  Map<String,Object> payload= new HashMap();
	  payload.put("name", "vikram_m");
	  payload.put("company", "medextech");
	  Response response=RestAssured.given().contentType(ContentType.JSON).body(payload).when().patch("http://localhost:3000/trainees/29");
	  System.out.println("Status code:"+response.getStatusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.jsonPath().getString("name"),"vikram_m");
  }
}
	  
