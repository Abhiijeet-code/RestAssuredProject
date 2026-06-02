package practice;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import testdata.Employee;

public class TestSerializationAndDeserialization {
	
	@Test
	public void employeeData() throws JsonProcessingException
	{
		Employee emp = new Employee();
		emp.setFirstName("anil");
		emp.setLastName("yadav");
		emp.setGender("male");
		emp.setAge(20);
		emp.setMarried(false);
		
		
		String jsonPayload = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		System.out.println(jsonPayload);
		
		RestAssured.baseURI = "https://httpbin.org/post";
		
		Response response = RestAssured.given()
								.contentType(ContentType.JSON)
								.body(emp)								//.body(jsonPayload)
								.when()
								.post();
		response.prettyPrint();
		
		response.then().statusCode(200);
		
		
		// convert jsonstring to class object 
		
		Employee emp2 = new ObjectMapper().readValue(jsonPayload,Employee.class);
		System.out.println(emp2.getFirstName());
		System.out.println(emp2.getLastName());
		
	}
	

}
