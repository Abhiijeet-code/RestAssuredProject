package in.at.test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class JsonSchemaValidator {
	
	@Test
	 public void jsonSchemaValidator() {

        given()
        .when()
            .get("https://fakestoreapi.com/products")
        .then()
            .assertThat()
            .body(io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath("fakeStoreApiJsonSchema.json"));
    }
}
