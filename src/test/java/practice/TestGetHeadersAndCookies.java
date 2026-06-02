package practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGetHeadersAndCookies {
	public RequestSpecification requestspec;
	String baseurl = "https://www.google.com";
	
	@BeforeClass
	public void initialization()
	{
		RestAssured.baseURI = baseurl;
		requestspec = RestAssured.given();
	}
	
	
	@Test
	public void getHeader()
	{
		Response response = requestspec.when()
						               .get();
		
		List<Header> headers = response.getHeaders().asList();
		for(Header header:headers )
		{
			System.out.println(header.getName() +": "+ header.getValue());
		}
		
		System.out.println("------------------------");
		
		Headers headerlist = response.getHeaders();
		for(Header header:headerlist)
		{
			System.out.println(header.getName() +": "+ header.getValue());
		}
	}
	
	@Test
	public void getCokkies()
	{
		Response response = requestspec.when()
									   .get();
		
		Map<String, String> cookiesMap = response.getCookies();
		cookiesMap.forEach((name,value)-> System.out.println("name : "+name+ "\t value : "+value));
		
		System.out.println("-----------------------------");
		
		Set<String> cookiesSet = cookiesMap.keySet();
		cookiesSet.forEach(cookieName -> System.out.println("Cookies is : "+cookieName) );
	}
}
