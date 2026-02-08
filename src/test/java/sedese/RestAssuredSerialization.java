package sedese;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import testdata.User;

public class RestAssuredSerialization {

	@Test
	public void serialization()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		User user= new User();
		user.setName("abc");
		user.setEmail("abc@gmail.com");
		
		RestAssured.given()
		   				.contentType(ContentType.JSON)
		   				.body(user)
		   			.when()
		   			    .post("/users")
		   			.then()
		   			    .statusCode(201);
		
		
	}
	
}
