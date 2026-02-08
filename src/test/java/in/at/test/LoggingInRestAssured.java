package in.at.test;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class LoggingInRestAssured {

	@Test
	public void logAllRequest()
	{
		JSONObject userdata = new JSONObject();
		userdata.put("name","abc");
		userdata.put("job", "tester");
		
		RestAssured.given()
						.contentType(ContentType.JSON)
						.body(userdata.toString())
						.log().all()
					.when()
						.post("https://reqres.in/api/users")
					.then()
						.statusCode(201);
	}
	
	@Test
	public void logRequestBody()
	{
		JSONObject userdata = new JSONObject();
		userdata.put("name", "abc");
		userdata.put("job", "tester");
		
		RestAssured.given()
						.contentType(ContentType.JSON)
						.body(userdata.toString())
						.log().body()
					.when()
						.post("https://reqres.in/api/users")
					.then()
						.statusCode(201);
	}
	
	@Test
	public void logAllResponse()
	{
		RestAssured.given()
					.when()
						.get("https://fakestoreapi.com/products")
					.then()
						.log().all();
	}
	
	@Test
	public void logResponseBody()
	{
		RestAssured.given()
					.when()
						.get("https://fakestoreapi.com/products")
					.then()
						.log().body();
	}
	
	@Test
	public void logResponseHeader()
	{
		RestAssured.given()
					.when()
						.get("https://fakestoreapi.com/products/1")
					.then()
						.log().headers();
					
	}
	
	@Test
	public void logResponseStatusCode()
	{
		RestAssured.given()
					.when()
						.get("https://fakestoreapi.com/products/1")
					.then()
						.log().status();
	}
	
	@Test
	public void logResponseCookies()
	{
		RestAssured.given()
					.when().log().cookies()
						.get("https://fakestoreapi.com/products")
					.then()
						.log().cookies();
	}
	
	@Test
	public void logIfValidationFails()
	{
		RestAssured.given()
					.when()
						.get("https://fakestoreapi.com/products")
					.then()
						//.log().ifValidationFails()
						//.log().ifValidationFails(LogDetail.BODY)
						//.log().ifValidationFails(LogDetail.HEADERS)
						.log().ifValidationFails(LogDetail.STATUS)
						.statusCode(201);
	}
	
	@Test
	public void logIfError()
	{
		RestAssured.given()
					.when()
						.get("https://fakestoreapi.com/products/test/log")
					.then()
						.log().ifError();
	}
	
	@Test
	public void logIfStatusCodeIsEqual()
	{
		RestAssured.given()
					.when()
						.get("https://fakestoreapi.com/products/1")
					.then()
						.log().ifStatusCodeIsEqualTo(200);
	}
}
