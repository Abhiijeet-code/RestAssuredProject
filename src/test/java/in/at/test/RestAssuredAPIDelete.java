package in.at.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredAPIDelete {

	@Test
	public void getAllItemsFromCart()
	{
		String baseUrl ="https://simple-grocery-store-api.glitch.me";
		String cartId = "lOakwc6CyH21WAmzbz8j6";
		String endPoint = "/carts/"+cartId+"/items";
		
		RestAssured.given()
						.baseUri(baseUrl)
				   .when()
				    	.get(endPoint)
				    .then()
				    	 .log().body();
	}
	
	@Test
	public void deleteAnItemFromCart()
	{
		String baseUrl ="https://simple-grocery-store-api.glitch.me";
		String cartId = "lOakwc6CyH21WAmzbz8j6";
		String itemId = "93115958";
		String endPoint = "/carts/"+cartId+"/items/"+itemId;
		
		//way1
/*		RestAssured.baseURI =baseUrl;
		RestAssured.basePath = endPoint;
		
		RequestSpecification requestSpec = RestAssured.given();
		
		Response response = requestSpec.delete();
		
		Assert.assertEquals(response.getStatusCode(), 204);
*/
		//way 2
		RestAssured.given()
						 .baseUri(baseUrl)
						 .basePath(endPoint)
					.when()
						 .delete()
					.then()
						 .statusCode(204);
	}
	
}
