package practice;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestPost {
	
	@Test
	public void test()
	{
		JSONObject jsonBody = new JSONObject();
		jsonBody.put("email", "abcjj123456@gmail.com");
		jsonBody.put("password","IamKing@1234");
		
		
		RestAssured.baseURI = "https://api.eventhub.rahulshettyacademy.com/api/auth/login";
		RequestSpecification reqspec = RestAssured.given();
		Response res = reqspec.header("Content-Type","application/json")	
					   .contentType(ContentType.JSON)
					   .body(jsonBody.toString())
					   .when()
					   .post();
		res.then()
		.log().body();
		
		String token = res.jsonPath().getString("token");
		System.out.println(token);
					   
				
	}

}
