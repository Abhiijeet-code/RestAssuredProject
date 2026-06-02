package practice;

import java.io.File;

import org.apache.http.entity.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestFileUpload {
	
	public RequestSpecification requestspec;
	
	
	@Test
	public void fileUpload()
	{
		RestAssured.baseURI = "https://httpbin.org/post";
		requestspec = RestAssured.given();
		
		File filepath = new File("C://Users//abhid//OneDrive//Desktop//Git.txt");
		
		Response response = requestspec
								.multiPart(filepath)
								.contentType("multipart/form-data")
								.when().post();
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(),200);
	}
	
	@Test
	public void imageUpload()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet/1/uploadImage";
		requestspec = RestAssured.given();
		
		File imagefile = new File("C://Users//abhid//OneDrive//Pictures//1234.jpg");
		
		Response response = requestspec
								.multiPart(imagefile)
								.contentType("multipart/form-data")
							.when()
								.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(),200);
	}

}
