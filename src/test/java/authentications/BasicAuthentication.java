package authentications;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuthentication {
	
	@Test
	public void basicAuthentication()
	{
		//way 1
	/*	RestAssured.baseURI = "https://postman-echo.com/basic-auth";
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.auth().basic("postman","password");
		
		Response response = requestSpec.get();
		
		System.out.println(response.getBody().asPrettyString());
		
		JsonPath jsonpath = response.jsonPath();
		String authenticated = jsonpath.getString("authenticated");
		
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(authenticated, "true");  */
		
		//way2
		RestAssured.given()
		                .auth().basic("postman", "password")
		             .when()
		                .get("https://postman-echo.com/basic-auth")
		              .then()
		              .statusCode(200)
		              .body("authenticated", Matchers.equalTo(true));
	}

}
