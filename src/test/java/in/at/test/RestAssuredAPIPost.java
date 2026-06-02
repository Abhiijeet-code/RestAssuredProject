package in.at.test;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testdata.Product;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class RestAssuredAPIPost {
	
	@Test
	public void addProductUsingJsonAsString()
	{
		String jsonRequestBody = "{\"title\": \"Laptop\", \"price\": \"200\", \"description\": \"14'' Laptop\", \"category\": \"Electronics\"}";
		
		//way1
		RestAssured.baseURI ="https://fakestoreapi.com/products";
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(jsonRequestBody);
		
		Response response = requestSpec.post();
		
		System.out.println(response.getBody().asPrettyString());
	
		
		//way2
		given()
		     .contentType(ContentType.JSON)
		     .body(jsonRequestBody)
		.when()
		     .post("https://fakestoreapi.com/products")
		.then()
		     .log().body();
	}
	
	@Test
	public void addProductUsingMap()
	{
		Map<String, String> jsonBody = new HashMap<>();
		jsonBody.put("title", "Laptop");
		jsonBody.put("price", "200");
		jsonBody.put("description", "14 inch Laptop");
		jsonBody.put("category", "Electronics");
		
		//way1 
/*		RestAssured.baseURI = "https://fakestoreapi.com/products";
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(jsonBody);
		
		Response response = requestSpec.post();
		
		System.out.println(response.getBody().asPrettyString());
	*/
		
		//way2
		given()
		     .baseUri("https://fakestoreapi.com/products")
		     .contentType(ContentType.JSON)
		     .body(jsonBody)
		.when()
		 	 .post()
		.then()
		     .log().body();
		 
		
	}

	@Test
	public void addProductUsingJSONObject() {
		
		JSONObject jsonBody = new JSONObject();
		jsonBody.put("title", "Laptop");
		jsonBody.put("price", "200");
		jsonBody.put("description", "14 inch Laptop");
		jsonBody.put("category", "Electronics");
		
		//way 1
/*		RestAssured.baseURI ="https://fakestoreapi.com/products";
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(jsonBody.toString());
		
		Response response = requestSpec.post();
		
		System.out.println(response.getBody().asPrettyString());
	*/
		
		//way2 
		given()
		    .baseUri("https://fakestoreapi.com/products")
		    .contentType(ContentType.JSON)
		    .body(jsonBody.toString())
		.when()
		     .post()
		 .then()
		     .log().body();
	}
	
	@Test
	public void addProductUsingPOJO()
	{
		Product jsonBody = new Product();
		jsonBody.setTitle("Laptop");
		jsonBody.setPrice("200");
		jsonBody.setDescription("14 inch Laptop");
		jsonBody.setCategory("Electronics");
		
		//way1 
	/*	RestAssured.baseURI = "https://fakestoreapi.com/products";
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(jsonBody);
		
		Response response = requestSpec.post();
		
		System.out.println(response.getBody().asPrettyString());
	*/
		
		//way 2
		given()
			  .baseUri("https://fakestoreapi.com/products")
			  .contentType(ContentType.JSON)
			  .body(jsonBody)
		.when()
		 	  .post()
		 .then()
		  	  .log().body();
	}
	
	@Test
	public void addProductUsingExternalFile()
	{
		File Jsonfile = new File(System.getProperty("user.dir")+"//jsons//product.json");
		
		//way 1
/*		RestAssured.baseURI ="https://fakestoreapi.com/products";
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(Jsonfile);
		
		Response response = requestSpec.post();
		
		System.out.println(response.getBody().asPrettyString());
	*/	
		
		//way2
		given()
			 .baseUri("https://fakestoreapi.com/products")
			 .contentType(ContentType.JSON)
			 .body(Jsonfile)
	   .when()
	   		 .post()
	   .then()
	   		 .log().body();
	}
}
