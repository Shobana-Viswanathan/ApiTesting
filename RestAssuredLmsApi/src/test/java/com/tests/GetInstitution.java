package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetInstitution extends BaseUrl {
  @Test
  public void getinstitue() {
	  String url=get_url();
	  Response response=RestAssured
			  .given()
			  .when()
			  .get(url+"getAll/institution");
      System.out.println("Status code:"+response.getStatusCode());
      response.prettyPrint();
      Assert.assertEquals(response.getStatusCode(), 200);
	  
  }
}
