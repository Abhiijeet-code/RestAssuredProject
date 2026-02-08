package in.at.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseStatusCode {
	
	@Test
	public void validateResponseCode()
	{
		//way 1
	/*	RestAssured.baseURI = "https://fakestoreapi.com/products/1";
		RequestSpecification requestSpec = RestAssured.given();
		Response response = requestSpec.get();
		
		int statusCode = response.getStatusCode();
		
		System.out.println("Status code = "+statusCode);
		
		Assert.assertEquals(statusCode, 200); */
		
		//way2 
		
		RestAssured.given()
		 .when()
		  .get("https://fakestoreapi.com/products/1")
		 .then()
		  .statusCode(200);
	}
	
	@Test
	public void validateFailureResponseCode()
	{
		//way 1
	/*	RestAssured.baseURI = "https://fakestoreapi.com/products/1/test";
		RequestSpecification requestSpec = RestAssured.given();
		Response response = requestSpec.get();
		
		int statusCode = response.statusCode();
		
		Assert.assertEquals(statusCode, 404);  */
		
		//way 2
		RestAssured.given()
		 .when()
		  .get("https://fakestoreapi.com/products/1/test")
		 .then()
		  .statusCode(404);
	}

}
