package authentications;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class APIKeyAuthentication {

	@Test
	public void apiKeyAuthemtication()
	{
		//way 1
/*		RestAssured.baseURI ="https://api.openweathermap.org";
		RestAssured.basePath="/data/2.5/weather";
		
		RequestSpecification requestSpec  = given();
		requestSpec.queryParam("q","mumbai");
		requestSpec.queryParam("app_id", "api-key");
		
		Response response = requestSpec.get();
		
		JsonPath jsonpath = response.jsonPath();
		
		Assert.assertEquals(jsonpath.getString("name"), "mumbai");
		
		*/
		
		//way2
		given()
		     .queryParam("q", "mumbai")
		     .queryParam("app_id", "api_key")
		.when()
		     .baseUri("https://api.openweathermap.org")
		     .basePath("/data/2.5/weather")
		     .get()
		.then()
		     .body("name",Matchers.equalTo("mumbai"));
		
	}

}
