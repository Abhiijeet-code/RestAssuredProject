package authentications;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;



public class oAuth2Authentication {
	
	public static  String client_id ="your_client_id";
	public static String client_secret = "your_client_secret";
	
	@Test
	public void auth2Authentication()
	{
		//way 1 
/*		RestAssured.baseURI ="https://example.com/oauth/token";
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.auth().preemptive().basic(client_id, client_secret);
		requestSpec.param("grant_type", "client_credentials");
		
		Response response = requestSpec.post();
		
		System.out.println(response.getBody().asPrettyString());
		
		String accessToken = response.jsonPath().getString("access-token");
		
		RestAssured.baseURI ="https://example.com/api/users";
		requestSpec.header("Authorization","Bearer "+accessToken);
		
		response = requestSpec.get();
		System.out.println(response.getBody().asPrettyString());
		
		*/
		
		//way 2 
		
		String accessToken = given()
							.auth().preemptive().basic(client_id, client_secret)
							.param("grant_type","client_credentials")
					  .when()
					  		.post("https://example.com/oauth/token").jsonPath().getString("access-token");
		
		given()
			  .header("Authorization", "Bearer "+accessToken)
		.when()
			  .get("https://example.com/api/users")
		.then()
			  .log().body();
		     
		
		
	}
}
