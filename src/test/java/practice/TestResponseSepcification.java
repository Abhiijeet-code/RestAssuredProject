package practice;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class TestResponseSepcification {
	
	ResponseSpecification responsespec;
	
	@BeforeClass
	public void createResponseSepc() {
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		
		builder.expectContentType(ContentType.JSON)
		.expectStatusCode(200)
		.expectStatusLine("HTTP/1.1 200 OK")
		.expectResponseTime(Matchers.lessThan(3000L));
		
//		builder.expectContentType(ContentType.JSON);
//		builder.expectStatusCode(200);
//		builder.expectStatusLine("HTTP/1.1 200 OK");
//		builder.expectResponseTime(Matchers.lessThan(3000L));
		
		responsespec = builder.build();
	}
	
	
	@Test
	public void getTest()
	{
		RestAssured.given()
						.baseUri("https://restful-booker.herokuapp.com/booking")
					.when()
						.get()
					.then()
						.spec(responsespec)
						.body("size()", Matchers.greaterThan(0));
//					    .statusCode(200)
//					    .statusLine("HTTP/1.1 200 OK")
//					    .contentType(ContentType.JSON)
//					    .time(Matchers.lessThan(3000L));
	}
	
	@Test
	public void getBookingByName() {
		RestAssured.given()
		  			   .baseUri("https://restful-booker.herokuapp.com/booking")
		  			   .queryParam("firstname","sally")
		  		   .when()
		  		   		.get()
		  		   	.then()
		  		   		.spec(responsespec);
//		  		   		.statusCode(200)
//		  		   		.statusLine("HTTP/1.1 200 OK")
//		  		   		.contentType(ContentType.JSON)
//		  		   		.time(Matchers.lessThan(3000L));
		  		 
	}
}
