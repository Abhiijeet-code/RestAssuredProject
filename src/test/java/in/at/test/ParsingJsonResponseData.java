package in.at.test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.json.JSONObject;

import io.restassured.http.ContentType;

public class ParsingJsonResponseData {
	
	public void jsonResponseBody()
	{
		Response res = 
						given()
							.contentType(ContentType.JSON)
						.when()
							.get("http://localhost:3000/post");
						
		JSONObject jo =new JSONObject(res.asPrettyString());
		
		boolean status =false;
		
		for(int i=0; i<jo.getJSONArray("book").length();i++)
		{
			String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();  //{object} -- [aaray] -- {object}
			
			if(bookTitle.contains("The Lord"))
			{
				status = true;
				break;
			}
		}
	}

}
