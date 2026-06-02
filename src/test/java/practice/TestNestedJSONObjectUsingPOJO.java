package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import testdata.EmployeeAddress;
import testdata.EmployeePOJO;

public class TestNestedJSONObjectUsingPOJO {

	@Test
	public void testNestedAddressInUser(){
		 EmployeePOJO emp = new EmployeePOJO();
		 emp.setFirstName("abc");
		 emp.setLastName("xyz");
		 emp.setGender("male");
		 emp.setAge(30);
		 emp.setMarried(false);
		 
		 EmployeeAddress empadd = new EmployeeAddress();
		 empadd.setStreet("Park Avenue");
		 empadd.setCity("Vijaywada");
		 empadd.setState("Andhra Pradesh");
		 empadd.setPincode(530012);
		 
		 emp.setAddress(empadd);
		 
		 
		 
		 RestAssured.baseURI = "https://httpbin.org/post";
		 Response response = RestAssured.given()
				 						.contentType(ContentType.JSON)
				 						.body(emp)
				 						.when().post();
		 response.prettyPrint();
		 
		 response.then().statusCode(200);
		 
		 EmployeePOJO empVal = response.jsonPath().getObject("json",EmployeePOJO.class);
		 System.out.println(empVal.getFirstName());
		 System.out.println(empVal.getAddress().getState());
	}
}
