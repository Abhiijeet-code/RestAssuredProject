package chaning;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import com.github.javafaker.Faker;

public class CreateUser {

	@Test
	public void testCreateUser(ITestContext context) {
		Faker faker = new Faker();

		JSONObject jo = new JSONObject();
		jo.put("name",faker.name().fullName());
		jo.put("gender","Male");
		jo.put("email",faker.internet().emailAddress());
		jo.put("status", "Inactive");
		
		
		int id = given()
					.contentType("application/json")
					.body(jo.toString())
				.when()
					.post("https://gorest.co.in/public/v2/users")
					.jsonPath().getInt("id");
		
		System.out.println(id);
		
	//	context.setAttribute("user_id",id);
		
		context.getSuite().setAttribute("user_id", id); // to use it at suite level
	}

}
