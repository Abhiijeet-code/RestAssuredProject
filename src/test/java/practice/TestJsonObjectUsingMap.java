package practice;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class TestJsonObjectUsingMap {
	
	public RequestSpecification requestspec;
	@BeforeClass
	public void initailization()
	{
		baseURI = "https://reqres.in/api/users";
		requestspec = given();
	}
	
	@Test
	public void jsonObjectUsingMap()
	{
		Map<String,Object> userDetail = new HashMap<String,Object>(); 
		userDetail.put("firstName", "abhi");
		userDetail.put("lastName","abhi");
		userDetail.put("age",28);
		userDetail.put("IsMarried",false);
		
		ArrayList<String>hobbies = new ArrayList<String>();
		hobbies.add("cricket");
		hobbies.add("books");
		hobbies.add("badminton");
		
		userDetail.put("hobbies",hobbies);
		
		Map<String,String> techSkills = new HashMap<String,String>();
		techSkills.put("Programming","Java");
		techSkills.put("WebAutomation", "Selenium");
		techSkills.put("API Testing","Rest Assured");
		
		userDetail.put("TechSkills",techSkills);
		
		Response response = requestspec.contentType(ContentType.JSON)
										.body(userDetail.toString())
										.when()
										.post();
		
		response.prettyPrint();
		
		response.then()
				.statusCode(201)
				.statusLine("HTTP/1.1 201 CREATED")
				.body("TechSkills.Programming ", equalTo("Java"));
				
		
	}

}
