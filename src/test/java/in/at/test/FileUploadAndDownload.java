package in.at.test;

import java.io.File;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FileUploadAndDownload {
	
	public  void singleFileUpload()
	{
		File myFile = new File("C://Users//abhid//OneDrive//Desktop//Git.txt");
		
		given()
			.multiPart(myFile)
			.contentType("multipart/form-data")
		.when()
			.post("url")
		.then()
			.statusCode(200)
			.body("filename" ,equalTo("Test1.txt"))
			.log().all();
	}
	
	public  void multipleFileUpload()
	{
		File myFile1 = new File("C://Users//abhid//OneDrive//Desktop//Git.txt");
		File myFile2 = new File("C://Users//abhid//OneDrive//Desktop//Jenkins run config.txt");
		
		given()
			.multiPart(myFile1)
			.multiPart(myFile2)
			.contentType("multipart/form-data")
		.when()
			.post("url")
		.then()
			.statusCode(200)
			.body("[0]filename" ,equalTo("Test1.txt"))
			.body("[1]filename" ,equalTo("Test1.txt"))
			.log().all();
	}
}
