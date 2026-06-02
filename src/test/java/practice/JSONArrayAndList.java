package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONArrayAndList {
	public RequestSpecification requestspec;
	@BeforeClass
	public void initailization() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		requestspec = RestAssured.given();
		
	}
	
	@Test
	public void jsonArray()
	{
		JSONObject user1 = new JSONObject();
		user1.put("firstName","Abhi");
		user1.put("lastName","Patil");
		user1.put("age", 28);
		user1.put("salary",10000.25);
		
		JSONObject user2 = new JSONObject();
		user2.put("firstName","Abhi");
		user2.put("lastName","Patil");
		user2.put("age", 28);
		user2.put("salary",10000.25);
		
		JSONObject user3 = new JSONObject();
		user3.put("firstName","Abhi");
		user3.put("lastName","Patil");
		user3.put("age", 28);
		user3.put("salary",10000.25);
		
		JSONArray jsonArrayPayload = new JSONArray();
		jsonArrayPayload.put(user1);
		jsonArrayPayload.put(user2);
		jsonArrayPayload.put(user3);
		
		Response response = requestspec.contentType(ContentType.JSON)
									   .body(jsonArrayPayload)
									   .when()	
									   .post();
		response.prettyPrint();
		response.then()
				.statusCode(201);
	}

	
	@Test
	public void jsonArrayUsingList()
	{
		Map<String, Object> user1 = new HashMap<String , Object>();
		user1.put("firstName","Abhi");
		user1.put("lastName","Patil");
		user1.put("age", 28);
		user1.put("salary",10000.25);
		
		Map<String, Object> user2 = new HashMap<String , Object>();
		user2.put("firstName","Abhi");
		user2.put("lastName","Patil");
		user2.put("age", 28);
		user2.put("salary",10000.25);
		
		Map<String, Object> user3 = new HashMap<String , Object>();
		user3.put("firstName","Abhi");
		user3.put("lastName","Patil");
		user3.put("age", 28);
		user3.put("salary",10000.25);
		
		List<Map<String,Object>> jsonArrayPayload = new ArrayList<>();
		
		Response response = requestspec
				.contentType(ContentType.JSON)
				.body(jsonArrayPayload)
				.when().post();
		
		response.prettyPrint();
		
		response.then();
	}
}
