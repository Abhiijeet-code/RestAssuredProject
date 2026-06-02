package practice;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
public class TestValidateResponseBody {
	public String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjQ4NjEsImVtYWlsIjoiYWJjamoxMjM0NTZAZ21haWwuY29tIiwiaWF0IjoxNzc5NzM3MjgxLCJleHAiOjE3ODAzNDIwODF9.SvmDrUXatmg3AMyT1HwTk_W5_Wb4_19Nyme8xAFkC98";
	
	@Test
	public void validateResponseBodyAsString()
	{
		RestAssured.baseURI= "https://api.eventhub.rahulshettyacademy.com/api/events";
		
		RequestSpecification requestspec = RestAssured.given();
		requestspec.header("Authorization","Bearer "+token);
		
		Response response = requestspec.get();
		
		String responsebody = response.getBody().asPrettyString();
		
		System.out.println("Response body : "+responsebody);
		
		Assert.assertEquals(responsebody.contains("Hyderabad"),true);
	}
	
	@Test
	public void validateResponseBody()
	{
		RestAssured.baseURI= "https://api.eventhub.rahulshettyacademy.com/api/events";
		
		RequestSpecification requestspec = RestAssured.given();
		requestspec.headers("Authorization","Bearer "+token);
		
		Response response = requestspec.get();
		
		JsonPath jsonbody = response.jsonPath();
		
		System.out.println(response.asPrettyString());
		
		String city = jsonbody.get("data[2].city");
		System.out.println(city);
		
		Assert.assertEquals(city, "Hyderabad");
		
	}

}
