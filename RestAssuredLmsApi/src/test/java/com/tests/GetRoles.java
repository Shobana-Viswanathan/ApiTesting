package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import io.restassured.RestAssured;

public class GetRoles extends BaseUrl {
  @Test
  public void getRoles() {
	  String url=get_url();
	  String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY5YzM4NGE2NmFiZjZjNTUwZmU0NWY3NSIsImlhdCI6MTc4MTY3Nzg1MywiZXhwIjoxNzgxOTM3MDUzfQ.soVnya-GeHXnHk2S-uTMvTrP4BjSORhOxr1BdiAvB-M";
	  Response response=RestAssured.given()
			  .header("Authorization" , "Bearer "+ token)
			  .when()
			  .get(url+"roles/getAll");
	  response.prettyPrint();
	  System.out.println("Status code:"+response.getStatusCode());
	  Assert.assertEquals(response.getStatusCode(), 200);
	  
  }
}
