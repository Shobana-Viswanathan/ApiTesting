package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.containsString;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HealthCheckGetTest extends BaseUrl {
  @Test
  public void getTest() {
	  String url=get_url();
	  Response response=RestAssured
			  .given()
			  .when()
			  .get(url);
	  System.out.println(response.getStatusCode());
	  response.then().statusCode(200);
	  response.then().body(containsString("API Running"));	  
  }
}

