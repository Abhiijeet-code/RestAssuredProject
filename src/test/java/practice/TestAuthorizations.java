package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TestAuthorizations {
	
	@Test
	public void basicAuth()
	{
		RestAssured.baseURI = "https://postman-echo.com/basic-auth";
		
		RequestSpecification requestspec = RestAssured.given();
		requestspec.auth().basic("postman", "password");
		
		Response response = requestspec.get();
		
		System.out.println(response.getBody().asPrettyString());
		
		System.out.println(response.getStatusLine());
		
		Assert.assertEquals(response.jsonPath().getString("authenticated"),"true");
	}
	
	@Test
	public void preemptiveAuth()
	{
		RestAssured.baseURI = "https://postman-echo.com/basic-auth";
		
		RequestSpecification requestspec = RestAssured.given();
		requestspec.auth().preemptive().basic("postman", "password");
		
		Response response = requestspec.get();
		
		System.out.println(response.getBody().asPrettyString());
	}
	
	@Test
	public void digestAuth()
	{
		RestAssured.baseURI = "https://httpbin.org/digest-auth";
		RestAssured.basePath = "/undefined/abc/abc";
		
		RequestSpecification requestspec = RestAssured.given();
		requestspec.auth().digest("abc", "abc");
		
		Response response = requestspec.get();
		
		System.out.println(response.getBody().asPrettyString());
		
		
	}

}
