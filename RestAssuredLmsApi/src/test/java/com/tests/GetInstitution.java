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
      response.then().statusCode(200);	  
  }
  @Test
  public void invalid() {
      String url = get_url();

      Response res = RestAssured
              .given()
              .when()
              .get(url + "getAll");

      System.out.println("Status Code: " + res.getStatusCode());
      res.prettyPrint();

      res.then().statusCode(404);
  }
  
}
