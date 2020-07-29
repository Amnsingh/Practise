package demo

import org.json.simple.JSONObject
import org.junit.Before
import org.junit.Test

import io.restassured.RestAssured
import io.restassured.http.ContentType
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
		httpRequest.then().statusCode(200)
		JsonPath jsonPathEvaluator = response.jsonPath()
		println(response.getBody().asString())
		String firstName = jsonPathEvaluator.get("firstName[0]")
		println(firstName)
		Assert.assertTrue(firstName.equals("Henry"));
	}
	@Test
	void test_POST() {
		JSONObject request = new JSONObject()
		request.put("firstName", "Brendon")
		request.put("lastName", "McCullum")
		request.put("subjectId", 2)
		
		RequestSpecification httpRequest = RestAssured.given()
		httpRequest.contentType(ContentType.JSON);
		httpRequest.accept(ContentType.JSON);
		httpRequest.body(request.toJSONString());
		
		Response response = httpRequest.post("/users")
		JsonPath jsonPathEvaluator = response.jsonPath()
		String firstName = jsonPathEvaluator.get("firstName")
		Assert.assertTrue(firstName.equals("Brendon"))
		httpRequest.then().statusCode(201)
	}

}
