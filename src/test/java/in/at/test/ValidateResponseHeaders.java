package in.at.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*; //import manually

public class ValidateResponseHeaders {
	
	@Test
	public void printAllHeaders()
	{
		//way 1
	/*	RestAssured.baseURI = "https://fakestoreapi.com/products/1";
		RequestSpecification requestSpec  = RestAssured.given();
		Response response = requestSpec.get();
		
		Headers headers = response.headers();
		
		for(Header header : headers)
		{ 
			System.out.println(header.getName()+"-->"+header.getValue());        
		}
		*/
		
		//way2
		given()
		 .when() 
		  .get("https://fakestoreapi.com/products/1")
		   .then()
		    .log().headers();
	}
	
	@Test
	public void getSpecifiedHeader()
	{
		//way 1
	/*	RestAssured.baseURI = "https://fakestoreapi.com/products/1";
		RequestSpecification requestSpec = RestAssured.given();
		Response response = requestSpec.get();
		
		System.out.println(response.getHeader("Content-Type"));
		System.out.println(response.getHeader("Connection"));
		
		*/
		
		//way 2
		Response response =given()
							.when()
								.get("https://fakestoreapi.com/products/1");
		
		System.out.println(response.getHeader("Content-Type"));
		System.out.println(response.getHeader("Connection"));
	}
	
	@Test
	public void validateResponseHeaders()
	{
		//way 1
	/*	RestAssured.baseURI = "https://fakestoreapi.com/products/1";
		RequestSpecification requestSpec = RestAssured.given();
		Response response = requestSpec.get();
		
		String contentType = response.getHeader("Content-Type");
		String connection = response.getHeader("Connection");
		
		Assert.assertEquals(contentType,"application/json; charset=utf-8");
		Assert.assertEquals(connection,"keep-alive");
	*/
		
		//way 2
		given()
		 .when()
		  .get("https://fakestoreapi.com/products/1")
		 .then()
		   .header("Content-Type", "application/json; charset=utf-8")
		   .header("Connection", "keep-alive");
	}

}
