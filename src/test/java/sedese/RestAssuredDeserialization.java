package sedese;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import testdata.User;

public class RestAssuredDeserialization {
	
	@Test
	public void deserialization()
	{
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		Response response = RestAssured.get("/users/1");
		
		User fetcheduser = response.as(User.class);
		
		System.out.println(fetcheduser.getId());
		System.out.println(fetcheduser.getName());
		System.out.println(fetcheduser.getEmail());
	}

}
