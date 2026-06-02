package practice;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class localAPI {
	
	//public RequestSpecification requestspec;
	@BeforeClass
	public void initailization()
	{
		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.basePath = "/users";
		
	}
	
	@Test
	public void readUser()
	{
		Response response = RestAssured.given().get();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(enabled =false)
	public void createUser()
	{
		JSONObject jsonbody = new JSONObject();
		jsonbody.put("id","3");
		jsonbody.put("name","anil");
		jsonbody.put("age",28);
		
		
		Response response = RestAssured.given()
								.contentType(ContentType.JSON)
								.body(jsonbody.toString())
								.when()
								.post();
		response.prettyPrint();
		
		Assert.assertEquals(response.getStatusCode(),201);
	}
	
	@Test
	public void updtaeUser()
	{
		JSONObject jsonbody = new JSONObject();
		jsonbody.put("name","anil");
		jsonbody.put("age",40);
		
		Response response = RestAssured.given()
								.header("Content-Type","application/json")
								.contentType(ContentType.JSON)
								.body(jsonbody)
								.when().put("/3");
		
		response.prettyPrint();
	}
	
	@Test
	public void deleteUser()
	{
		Response response = RestAssured.delete("/3");
		response.prettyPrint();
								
	}
}
