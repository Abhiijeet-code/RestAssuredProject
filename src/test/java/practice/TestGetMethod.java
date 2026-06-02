package practice;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGetMethod {
	
	@Test
	public void test()
	{
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjQ4NjEsImVtYWlsIjoiYWJjamoxMjM0NTZAZ21haWwuY29tIiwiaWF0IjoxNzc5NzM3MjgxLCJleHAiOjE3ODAzNDIwODF9.SvmDrUXatmg3AMyT1HwTk_W5_Wb4_19Nyme8xAFkC98";
		RestAssured.baseURI= "https://api.eventhub.rahulshettyacademy.com/api";
		RestAssured.basePath = "/auth/me";
		RequestSpecification reqspec = RestAssured.given().header("Authorization" ,"Bearer "+token); 
		Response response = reqspec.when()
								.get();
		
		response.then()
				.statusCode(200)
				.log().body()
				.and()
				.log().headers();
		
		System.out.println(response.getTime());
	}
	
	public void testRes()
	{
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		RequestSpecification reqspec = RestAssured.given();
		Response res = reqspec.when()
				              .get();
		res.then()
			.statusCode(200)
			.log().headers();
	}

}
