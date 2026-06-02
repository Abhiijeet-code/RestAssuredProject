package practice;

import java.util.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import testdata.EmployeeJsonInclude;

public class TestJSONIncludeAndIgnore {
	
	@Test
	public void jsonIncludeDemo() throws JsonProcessingException
	{
		EmployeeJsonInclude emp = new EmployeeJsonInclude();
		emp.setFirstName("anil");
		emp.setLastName("yadav");
		emp.setGender("Male");
		emp.setAge(20);
		
		String[] hobbieslist = {"cricket","selenium"};
		emp.setHobbies(hobbieslist);
		
		List<String> degreelist = new ArrayList<>();
		degreelist.add("bcom");
		degreelist.add("mcom");
		emp.setDegree(degreelist);
		
		String jsonPayload = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		System.out.println(jsonPayload);
		
		String payload = "{\r\n"
				+ "  \"firstName\" : \"anil\",\r\n"
				+ "  \"lastName\" : \"yadav\",\r\n"
				+ "  \"gender\" : \"Male\",\r\n"
				+ "  \"age\" : 20,\r\n"
				+ "  \"hobbies\" : [ \"cricket\", \"selenium\" ],\r\n"
				+ "  \"degree\" : [ \"bcom\", \"mcom\" ],\r\n"
				+ "  \"married\" : false\r\n"
				+ "}";
		
		EmployeeJsonInclude empdse = new ObjectMapper().readValue(payload, EmployeeJsonInclude.class);
		System.out.println(empdse.getFirstName());
		System.out.println(empdse.getLastName());
		System.out.println(empdse.getAge());
		System.out.println(empdse.getGender());
		System.out.println(Arrays.toString(empdse.getHobbies()));
		System.out.println(empdse.getDegree());
	}

}
