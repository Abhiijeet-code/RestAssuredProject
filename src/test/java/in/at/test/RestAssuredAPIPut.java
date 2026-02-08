package in.at.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredAPIPut {
	
	//https://simple-grocery-store-api.glitch.me/carts/:cartId/items
	//cartid = "lOakwc6CyH21WAmzbz8j6"
	
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
	public void updateAnItemQuantity()
	{
		JSONObject jsonBody = new JSONObject();
		jsonBody.put("productId", 4643);
		jsonBody.put("quantity", 12);
		
		String baseUrl ="https://simple-grocery-store-api.glitch.me";
		String cartId = "lOakwc6CyH21WAmzbz8j6";
		String itemId = "93115958";
		String endPoint = "/carts/"+cartId+"/items/"+itemId;
		
		//way1 
/*		RestAssured.baseURI = baseUrl;
		RestAssured.basePath = endPoint;
		
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.body(jsonBody.toString());
		
		Response response = requestSpec.put();
		
		Assert.assertEquals(response.getStatusCode(), 204);
	*/
		//way2
		RestAssured.given()
						  .baseUri(baseUrl)
						  .basePath(endPoint)
				   .when()
				   		 .put()
				   .then()
				    	.statusCode(204);
		
	}
}
