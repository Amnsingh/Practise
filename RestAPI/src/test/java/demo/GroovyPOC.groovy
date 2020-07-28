package demo

import static org.testng.Assert.assertEquals

import org.junit.Before
import org.junit.Test

import io.restassured.RestAssured
import io.restassured.path.json.JsonPath
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import junit.framework.Assert

class GroovyPOC {
	@Before
	void setup() {
		RestAssured.baseURI="http://localhost:3000/"
	}
	@Test
	void test_GET() {
		RequestSpecification httpRequest = RestAssured.given()
		Response response = httpRequest.get("/users");
		//httpRequest.then().statusCode(200)
		int statusCode=response.getStatusCode()
		JsonPath jsonPathEvaluator = response.jsonPath()
		println(response.getBody().asString())
		String firstName = jsonPathEvaluator.get("firstName[0]")
		println(firstName)
		Assert.assertTrue(firstName.equals("Henry"));
		assertEquals(statusCode, 200)
	}

}
