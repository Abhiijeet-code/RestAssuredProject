package practice;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestPut {
	
	@Test
	public void test()
	{
		String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjQ4NjEsImVtYWlsIjoiYWJjamoxMjM0NTZAZ21haWwuY29tIiwiaWF0IjoxNzc5NzM3MjgxLCJleHAiOjE3ODAzNDIwODF9.SvmDrUXatmg3AMyT1HwTk_W5_Wb4_19Nyme8xAFkC98";
		
		JSONObject jsonBody = new JSONObject();
		jsonBody.put("title", "Tech Summit 2026");
		jsonBody.put("description", "A premier technology conference.");
		jsonBody.put("category", "Conference");
		jsonBody.put("venue", "Bangalore International Centre");
		jsonBody.put("city", "Bangalore");
		jsonBody.put("eventDate", "2026-06-15T09:00:00.000Z");
		jsonBody.put("price",1500);
		jsonBody.put( "totalSeats",500);
		jsonBody.put("imageUrl", "https://example.com/banner.jpg");
		
		Map<String,String> multiheaders = new HashMap<>();
		multiheaders.put("Authorization", "Bearer "+token);
		multiheaders.put("Content-Type","application/json");
		
		RestAssured.baseURI = "https://api.eventhub.rahulshettyacademy.com/api/events/";
		
		Response res = RestAssured.given().pathParam("id", "1")
				       .headers(multiheaders)
				       .contentType(ContentType.JSON)
				       .body(jsonBody.toString())
				       .when()
				       .put("{id}");
		
		res.then()
		   .log().body()
		   .log().status();
		
		System.out.println(res.jsonPath().getString("success"));
		
	}

}
