package practice;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestDeserializeJSON {
	
	@Test
	public void deserializeJSONData()
	{
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjQ4NjEsImVtYWlsIjoiYWJjamoxMjM0NTZAZ21haWwuY29tIiwiaWF0IjoxNzc5NzM3MjgxLCJleHAiOjE3ODAzNDIwODF9.SvmDrUXatmg3AMyT1HwTk_W5_Wb4_19Nyme8xAFkC98";
		RestAssured.baseURI = "https://api.eventhub.rahulshettyacademy.com/api/events";
		
		RequestSpecification requestspec = RestAssured.given();
		
		JSONObject jsonbody = new JSONObject();
		jsonbody.put("title","Tech Summit 2029");
		jsonbody.put("description","A premier technology conference.");
		jsonbody.put("category","Conference");
		jsonbody.put("venue","Bangalore International Centre");
		jsonbody.put("city","Bangalore");
		jsonbody.put("eventDate","2026-06-15T09:00:00.000Z");
		jsonbody.put("price",1500);
		jsonbody.put("totalSeats",500);
		jsonbody.put("imageUrl","https://example.com/banner.jpg");
		
		
		Response response = requestspec.header("Authorization", "Bearer "+token)
										.contentType(ContentType.JSON)
										.body(jsonbody.toString())
										.when()
										.post();
		
		System.out.println(response.getStatusLine());
		response.prettyPrint();
		
		JSONPostRequestResponse responseClass = response.as(JSONPostRequestResponse.class);
		
		System.out.println(responseClass.data.city);
		
		
	}
	
	

}
