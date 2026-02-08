package authentications;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;

public class PreemptiveAuthentication {
	
	@Test
	public void preemptiveAuthentication()
	{
		//way 1
	/*	RestAssured.baseURI ="https://postman-echo.com/basic-auth";
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.auth().preemptive().basic("postman", "password");
		
		Response response = requestSpec.get();
		
		JsonPath jsonpath = response.jsonPath();
		String authenticated = jsonpath.getString("authenticated");
		
		Assert.assertEquals(authenticated, "true");
		Assert.assertEquals(response.statusCode(), 200);
		*/
		
		//way 2
		given()
		      .auth().preemptive().basic("postman", "password")
		.when()
		      .get("https://postman-echo.com/basic-auth")
		.then()
		      .statusCode(200)
		      .body("authenticated", Matchers.equalTo(true));
	}

}
