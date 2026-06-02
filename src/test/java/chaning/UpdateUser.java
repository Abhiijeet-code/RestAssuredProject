package chaning;

import org.json.JSONObject;
import org.testng.ITestContext;

import static io.restassured.RestAssured.*;
import com.github.javafaker.Faker;

public class UpdateUser {

	public void testUpdateUser(ITestContext context)
	{
		//int id= (int) context.getAttribute("user_id");
		int id = (int) context.getSuite().getAttribute("user_id");
		
		Faker faker = new Faker();
		
		JSONObject jo = new JSONObject();
		jo.put("name", faker.name().fullName());
		jo.put("gender", "Male");
		jo.put("email", faker.internet().emailAddress());
		jo.put("status", "active");
				
		
		given()
			.contentType("application/json")
			.pathParam("id",id)
			.body(jo.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
	}
}
