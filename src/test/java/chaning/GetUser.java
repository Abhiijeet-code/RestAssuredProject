package chaning;

import static io.restassured.RestAssured.*;

import org.testng.ITestContext;

public class GetUser {
	
	public void testGetUser(ITestContext context)
	{
		//int id = (int) context.getAttribute("user_id");
		
		int id = (int) context.getSuite().getAttribute("user_id");
		
		given()
			.contentType("application/json")
			.pathParam("id", id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().body();
	}

}
