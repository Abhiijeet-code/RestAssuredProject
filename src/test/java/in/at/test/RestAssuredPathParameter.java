package in.at.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RestAssuredPathParameter {

	@Test
	public void pathParamter()
	{
		RestAssured.given()
						.pathParam("owner", "ownerName")
						.pathParam("repo", "repoName")
					.when()
					    .get("https://api.github.com/repos/{owner}/{repo}")
					.then()
					    .log().body();
	}
}
