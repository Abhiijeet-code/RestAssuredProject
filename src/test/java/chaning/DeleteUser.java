package chaning;
import static io.restassured.RestAssured.*;

import org.testng.ITestContext;

public class DeleteUser {
	
	public void testDeleteUser(ITestContext context)
	{
		//int id = (int) context.getAttribute("user_id");
		
		int id = (int) context.getSuite().getAttribute("user_id");
		
		given()
			.pathParam("id",id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(204)
			.log().all();
		
	}

}
