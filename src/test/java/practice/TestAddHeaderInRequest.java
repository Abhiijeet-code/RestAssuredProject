package practice;

import java.util.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TestAddHeaderInRequest {
	
	@Test
	public void headerlis() {
		
		RestAssured.baseURI ="https://httpbin.org/get";
		
	//	Response response = RestAssured.given().header("Header1","value1").when().get();
		
		Map<String,String> reqheader = new HashMap<String,String>();
		reqheader.put("Header1","Value1");
		reqheader.put("Header2", "Value2");
		
		Header header1 = new Header("Header1","Value1");
		Header header2 = new Header("Header2","Value2");
		Header header3 = new Header("Header3","Value3");
		
		List<Header>headerlist = new ArrayList<Header>();
		headerlist.add(header1);
		headerlist.add(header2);
		headerlist.add(header3);
		
		Headers headers = new Headers(headerlist);
		
		Response response = RestAssured.given().headers(headers).log().headers().when().get();
		
		
		response.prettyPrint();
	}

}
