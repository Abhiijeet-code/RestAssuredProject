package in.at.test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLResponse {
	
	
	public void testXMLResponse()
	{
		//way1
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page",equalTo("1"))
			.body("TravlereinformationResponse.travelers.Travelerinformation[0].name", equalTo("Vijay"));
		
		//way2
		Response res=
		given()
		.when()
		 	 .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		 Assert.assertEquals(res.getStatusCode(), 200);
		 Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		 
		 String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
		 Assert.assertEquals(pageNo, "1");
		 
		 String travelerName = res.xmlPath().get("TravlereinformationResponse.travelers.Travelerinformation[0].name").toString();
		 Assert.assertEquals(travelerName, "Vijay");
	}
	
	public void parsingXMLResponseBody()
	{
		Response res=
				given()
				.when()
				 	 .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xmlobj = new XmlPath(res.asString());
		
		List<String> travellers =  xmlobj.getList("TravlereinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(travellers.size(), 10);
		
		List<String> travellername = xmlobj.getList("TravlereinformationResponse.travelers.Travelerinformation.name");
		
		boolean status = false;
	
		for(String traveller : travellername)
		{
			if(traveller.contains("Vijay"))
			{
				status = true;
				break;
			}
		}
		Assert.assertEquals(status, true);
	}

}
