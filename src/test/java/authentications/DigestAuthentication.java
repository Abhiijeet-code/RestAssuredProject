package authentications;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;

public class DigestAuthentication {
	
	@Test
	public void digestAuthentication() {
		
/*		RestAssured.baseURI ="https://postman-echo.com/digest-auth";
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.auth().digest("postman", "password");
		
		Response response = requestSpec.get();
		
		JsonPath jsonpath = response.jsonPath();
		
		String authenticated = jsonpath.getString("authenticated");
		
		Assert.assertEquals(authenticated, "true");
		Assert.assertEquals(response.statusCode(), 200);
		
		*/
		
		RestAssured.given()
		    .auth().digest("postman", "password")
		.when()
		    .get("https://postman-echo.com/digest-auth")
		.then()
		    .statusCode(200)
		    .body("authenticated", Matchers.equalTo(true)).log().all();
		
	}

}
