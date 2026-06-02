package practice;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import testdata.EmployeeJsonInclude;

public class TestUnkownProperties {
	@Test
	public void unkownProperties() throws JsonMappingException, JsonProcessingException {
		String payload = "{\r\n" + "  \"firstName\" : \"anil\",\r\n" + "  \"lastName\" : \"yadav\",\r\n"
				+ "  \"gender\" : \"Male\",\r\n" + "  \"age\" : 20,\r\n"
				+ "  \"hobbies\" : [ \"cricket\", \"selenium\" ],\r\n" + "  \"degree\" : [ \"bcom\", \"mcom\" ],\r\n"
				+ "  \"married\" : false,\r\n" + "\"fullname\" : \"anil yadav\"\r\n" + "}";  /// here fullname is unkown propert as its not present in the pojo class

		ObjectMapper object = new ObjectMapper();

		object.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		EmployeeJsonInclude emp = object.readValue(payload, EmployeeJsonInclude.class);
		System.out.println(emp.getFirstName());
		System.out.println(emp.getLastName());
		System.out.println(emp.getAge());
		System.out.println(emp.getGender());
		System.out.println(emp.isMarried());
		System.out.println(Arrays.toString(emp.getHobbies()));
		System.out.println(emp.getDegree());
	}
}
