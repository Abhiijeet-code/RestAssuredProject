package practice;

import java.util.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import testdata.CompanyDetails;
import testdata.EmployeeAddress;
import testdata.EmployeePOJO;

public class TestComplexNestedPOJO {
	
	@Test
	public void companyEmployeesData() throws JsonProcessingException {
		
		CompanyDetails compDetail = new CompanyDetails();
		compDetail.setCompanyName("xyz Ltd");
		compDetail.setStreet("Arifac Avenue");
		compDetail.setCity("RK puram, Delhi");
		compDetail.setState("New Delhi");
		compDetail.setPincode(110066);
		
		List<String> banklist = new ArrayList<String>();
		banklist.add("HDFC");
		banklist.add("SBI");
		banklist.add("ICICI");
		
		compDetail.setbankAccounts(banklist);
		
		
		EmployeePOJO emp1= new EmployeePOJO();
		emp1.setFirstName("anil");
		emp1.setLastName("yadav");
		emp1.setGender("Male");
		emp1.setAge(30);
		emp1.setMarried(false);
		EmployeeAddress empadd = new EmployeeAddress();
		empadd.setStreet("Park Avenue");
		 empadd.setCity("Vijaywada");
		 empadd.setState("Andhra Pradesh");
		 empadd.setPincode(530012);
		 
		 emp1.setAddress(empadd);
		 
		 EmployeePOJO emp2= new EmployeePOJO();
			emp2.setFirstName("anil");
			emp2.setLastName("yadav");
			emp2.setGender("Male");
			emp2.setAge(30);
			emp2.setMarried(false);
			EmployeeAddress empadd2 = new EmployeeAddress();
			empadd2.setStreet("Park Avenue");
			 empadd2.setCity("Vijaywada");
			 empadd2.setState("Andhra Pradesh");
			 empadd2.setPincode(530012);
			 
			 emp2.setAddress(empadd2);
			 
			 EmployeePOJO emp3= new EmployeePOJO();
				emp3.setFirstName("anil");
				emp3.setLastName("yadav");
				emp3.setGender("Male");
				emp3.setAge(30);
				emp3.setMarried(false);
				EmployeeAddress empadd3 = new EmployeeAddress();
				empadd3.setStreet("Park Avenue");
				 empadd3.setCity("Vijaywada");
				 empadd3.setState("Andhra Pradesh");
				 empadd3.setPincode(530012);
				 
				 emp3.setAddress(empadd);
		
		
		List<EmployeePOJO> empList = new ArrayList<EmployeePOJO>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		
		compDetail.setEmployeelist(empList);
		
		String jsonPayload = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(compDetail);
		
		RestAssured.baseURI ="https://httpbin.org/post";
		
		Response response = RestAssured.given()
										.contentType(ContentType.JSON)
										.body(jsonPayload)
										.when().post();
		
		response.prettyPrint();
		
		CompanyDetails company = response.jsonPath().getObject("json", CompanyDetails.class);
		System.out.println(company.getCompanyName());
		
		for(String bank:company.getbankAccounts())
		{
			System.out.println(bank);
		}
		
		for(EmployeePOJO emp: company.getEmployeelist())
		{
			System.out.println(emp.getFirstName());
			
			System.out.println(emp.getAddress().getState());
		}
	}

}
