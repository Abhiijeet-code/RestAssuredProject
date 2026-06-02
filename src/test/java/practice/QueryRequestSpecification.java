package practice;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class QueryRequestSpecification {

	@Test
	public void querySpec() {
		
		JSONObject jsonBody = new JSONObject();
		jsonBody.put("title", "Laptop");
		jsonBody.put("price", "200");
		jsonBody.put("description", "14 inch Laptop");
		jsonBody.put("category", "Electronics");
		
		RestAssured.baseURI ="https://fakestoreapi.com/products";
		
		RequestSpecification requestspec = RestAssured.given();
		
		requestspec.header("header","headervalue")
		.contentType(ContentType.JSON)
		.body(jsonBody.toString());
		
		QueryableRequestSpecification res =SpecificationQuerier.query(requestspec);
		
		System.out.println(res.getBaseUri());
		
		Headers headerlist = res.getHeaders();
		for(Header h:headerlist)
		{
			System.out.println("Header name: "+h.getName() + "\t Header value :"+h.getValue());
		}
		
		
		
		
	}

}
