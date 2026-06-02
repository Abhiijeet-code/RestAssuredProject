package practice;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import testdata.Employee;

public class TestPOJOJsonArray {
	@Test
	public void empoyleeJsonArray()
	{
		Employee emp1 = new Employee();
		emp1.setFirstName("anil");
		emp1.setLastName("yadav");
		emp1.setGender("male");
		emp1.setAge(20);
		emp1.setMarried(false);
		
		Employee emp2 = new Employee();
		emp2.setFirstName("anil");
		emp2.setLastName("yadav");
		emp2.setGender("male");
		emp2.setAge(20);
		emp2.setMarried(false);
		
		Employee emp3 = new Employee();
		emp3.setFirstName("anil");
		emp3.setLastName("yadav");
		emp3.setGender("male");
		emp3.setAge(20);
		emp3.setMarried(false);
		
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		
		RestAssured.baseURI ="https://httpbin.org/post";
		
		Response response = RestAssured.given()
								.contentType(ContentType.JSON)
								.body(employeeList)
								.when()
								.post();
		
		response.prettyPrint();
		
		//Deserialize
		
		List<Employee> emp = response.jsonPath().getList("json",Employee.class);
		
		for(Employee e:emp)
		{
			System.out.println(e.getFirstName() +" "+e.getLastName());
		}
	}
}
