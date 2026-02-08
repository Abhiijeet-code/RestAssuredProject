package in.at.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredAPIGet {

	public static void main(String[] args) {
		//way1
		/*RestAssured.baseURI = "https://fakestoreapi.com/products";
		RequestSpecification requestspec = RestAssured.given();
		Response response = requestspec.get();
		
		System.out.println(response.prettyPrint());*/

		
		//way2
	/*	RestAssured.baseURI = "https://fakestoreapi.com/products";
		RequestSpecification requestspec = RestAssured.given();
		Response response = requestspec.request(Method.GET);
		
		System.out.println(response.prettyPrint());  */
		
		
		//way 3
		
		RestAssured.given()
		 .when()
		  .get("https://fakestoreapi.com/products")
		 .then()
		   .log().all();
		
	}
	
	
	

}
