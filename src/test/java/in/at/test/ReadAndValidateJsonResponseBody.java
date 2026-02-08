package in.at.test;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReadAndValidateJsonResponseBody {
	
	@Test
	public void readJSONResponse()
	{
		//way 1 
/*		RestAssured.baseURI = "https://fakestoreapi.com/products/1";
		RequestSpecification requestSpec = RestAssured.given();
		Response response = requestSpec.get();
		
		String responseBody = response.getBody().asString();
		
		System.out.println(responseBody);    */
		
		
		//way 2
		RestAssured.given()
		  .when() 
		   .get("https://fakestoreapi.com/products/1")
		    .then()
		      .log().body();
	}
	
	@Test
	public void readJSONResponseAndValidateAsString()
	{
		//way 1
/*		RestAssured.baseURI = "https://fakestoreapi.com/products/1";
		RequestSpecification requestSpec = RestAssured.given();
		Response response = requestSpec.get();
		
		String responseBody = response.getBody().asString();
		
		Assert.assertTrue(responseBody.contains("men's clothing"));  */
		
		//way 2
		String responseBody =RestAssured.given()
		 .when() 
		   .get("https://fakestoreapi.com/products/1").asString();
		
		Assert.assertTrue(responseBody.contains("men's clothing"));
		   
	}
	
	@Test
	public void readJSONResponseBodyAndValidate()
	{
		//way 1
	/*	RestAssured.baseURI = "https://fakestoreapi.com/products/1";
		RequestSpecification requestSpec = RestAssured.given();
		Response response = requestSpec.get();
		
		JsonPath jsonpath = response.jsonPath();
		
		String category = jsonpath.getString("category");
		String rate = jsonpath.getString("rating.rate");
		
		System.out.println("Category : "+category);
		System.out.println("Rate : "+rate);
		
		Assert.assertEquals(category, "men's clothing");
		Assert.assertEquals(rate, "3.9");    				*/
		
		
		//way 2
		RestAssured.given()
		  .when() 
		   .get("https://fakestoreapi.com/products/1")
		    .then()
		    .body("category", Matchers.equalTo("men's clothing"))
		    .body("rating.rate",Matchers.equalTo("3.9"));
	}

}
