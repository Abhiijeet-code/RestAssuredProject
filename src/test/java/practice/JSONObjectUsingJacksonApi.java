package practice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONObjectUsingJacksonApi {
	@Test
	public void objectMapper() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		ObjectNode user = objectMapper.createObjectNode();
		user.put("firstName", "abhi");
		user.put("lastName", "patil");
		user.put("age", 28);
		user.put("IsMarried", false);
		
		user.set("Hobbies", objectMapper.convertValue(Arrays.asList("cooking","cricket"), JsonNode.class));
		
		ObjectNode techSkills = objectMapper.createObjectNode();
		techSkills.put("Programming language", "Java");
		techSkills.put("WebAutomation", "Selenium");

		user.set("TechSkills", techSkills);

		System.out.println(objectMapper.writeValueAsString(user));

		String firstname = user.get("firstName").asText();

		Iterator<String> iterator = user.fieldNames();

		while (iterator.hasNext()) {
			System.out.println(iterator.next()); // it will print all the field name from the json i.e firstName,
													// lastName,etc
		}

		Iterator<JsonNode> valueiterator = user.elements();

		while (valueiterator.hasNext()) {
			System.out.println(valueiterator.next());
		}

		Iterator<Entry<String, JsonNode>> keyValueIterator = user.fields();
		while (keyValueIterator.hasNext()) {
			Entry<String, JsonNode> node = keyValueIterator.next();

			System.out.println(node.getKey() + ": " + node.getValue());
		}
		
		// removed the field fron json node or object
		String userRemoved = user.remove(firstname).asText();
		System.out.println(userRemoved);
		
		//update the json object 
		user.put("lastName", "abc");
		
		System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
		
		

		RestAssured.baseURI = "https://reqres.in/api/users";
		
		RequestSpecification requestspec = RestAssured.given();
		requestspec.contentType(ContentType.JSON);
		requestspec.body(user);
		
		Response response = requestspec.post();
		
	     response.prettyPrint();
	}
}
