package practice;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestValidateResponseHeaders {
	
	@Test
	public void validateHeader()
	{
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjQ4NjEsImVtYWlsIjoiYWJjamoxMjM0NTZAZ21haWwuY29tIiwiaWF0IjoxNzc5NzM3MjgxLCJleHAiOjE3ODAzNDIwODF9.SvmDrUXatmg3AMyT1HwTk_W5_Wb4_19Nyme8xAFkC98";
		RestAssured.baseURI= "https://api.eventhub.rahulshettyacademy.com/api";
		RestAssured.basePath = "/auth/me";
		
		RequestSpecification requestspec = RestAssured.given();
		requestspec.header("Authorization", "Bearer "+token);
		
		Response response = requestspec.get();
		
		String headerresponse = response.getHeader("Content-Type");
		System.out.println(headerresponse);
		
		Headers headerslist = response.getHeaders();
		for(Header header:headerslist)
		{
			System.out.println(header.getName() + ": " + header.getValue());
		}
		System.out.println("-------------------------------------");
		List<Header> headers = response.getHeaders().asList();
		for(Header header:headers)
		{
			System.out.println(header.getName() +": "+ header.getValue());
		}
		
		Assert.assertEquals(headerresponse , "application/json; charset=utf-8");
	}

}
