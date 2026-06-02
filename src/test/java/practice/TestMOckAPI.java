package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import testdata.EmployeePOJO;

public class TestMOckAPI {

	@Test
	public void mockApiAndDeserialize()
	{
		RestAssured.baseURI = "https://free.mockerapi.com/mock/c7800a0c-51dc-4cf8-a718-aa13d44ade0b";
		
		Response response = RestAssured.given().when().get();
		
		response.prettyPrint();
		
		EmployeePOJO empj = response.as(EmployeePOJO.class);
		System.out.println( empj.getFirstName());
		System.out.println(empj.getAddress().getState());
		
		
	}
}
