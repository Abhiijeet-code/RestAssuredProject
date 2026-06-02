package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class TestValidateResponse {

	@Test
	public void validateResponse()
	{
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjQ4NjEsImVtYWlsIjoiYWJjamoxMjM0NTZAZ21haWwuY29tIiwiaWF0IjoxNzc5NzM3MjgxLCJleHAiOjE3ODAzNDIwODF9.SvmDrUXatmg3AMyT1HwTk_W5_Wb4_19Nyme8xAFkC98";
		RestAssured.baseURI= "https://api.eventhub.rahulshettyacademy.com/api";
		RestAssured.basePath = "/auth/me";
		
		RequestSpecification requestspec = RestAssured.given();
		requestspec.header("Authorization", "Bearer "+token);
		
		Response res = requestspec.get();
		
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode,200);
		
		String statusline = res.getStatusLine();
		Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
		
	}
	@Test
	public void validatableResponse()
	{
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjQ4NjEsImVtYWlsIjoiYWJjamoxMjM0NTZAZ21haWwuY29tIiwiaWF0IjoxNzc5NzM3MjgxLCJleHAiOjE3ODAzNDIwODF9.SvmDrUXatmg3AMyT1HwTk_W5_Wb4_19Nyme8xAFkC98";
		RestAssured.baseURI= "https://api.eventhub.rahulshettyacademy.com/api";
		RestAssured.basePath = "/auth/me";
		
		RequestSpecification requestspec = RestAssured.given();
		requestspec.header("Authorization", "Bearer "+token);
		
		Response res = requestspec.get();
		
		ValidatableResponse validatable = res.then();
		
		validatable.statusCode(200);
		
		validatable.statusLine("HTTP/1.1 200 OK");
		
	}
	
	
}
