package demo

import java.net.Authenticator.RequestorType

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
	//@Test
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
	//@Test
	void test_POST() {
		JSONObject request = new JSONObject()
		request.put("firstName", "Brendon")
		request.put("lastName", "McCullum")
		request.put("subjectId", 2)
		
		RequestSpecification httpRequest = RestAssured.given()
		httpRequest.contentType(ContentType.JSON)
		httpRequest.accept(ContentType.JSON)
		httpRequest.body(request.toJSONString())
		
		Response response = httpRequest.post("/users")
		JsonPath jsonPathEvaluator = response.jsonPath()
		String firstName = jsonPathEvaluator.get("firstName")
		Assert.assertTrue(firstName.equals("Brendon"))
		httpRequest.then().statusCode(201)
	}
	//@Test
	void test_PUT() {
		JSONObject request = new JSONObject()
		request.put("firstName", "David")
		request.put("lastName", "Warner")
		request.put("subjectId", 1)
		
		RequestSpecification httpRequest = RestAssured.given()
		httpRequest.contentType(ContentType.JSON)
		httpRequest.accept(ContentType.JSON)
		httpRequest.body(request.toJSONString())
		
		Response response=httpRequest.put("/users/5")
		JsonPath jsonPathEvaluator = response.jsonPath()
		String lastName=jsonPathEvaluator.get("lastName")
		httpRequest.then().statusCode(200)
		Assert.assertTrue(lastName.equals("Warner"))
	}
	//@Test
	void test_PATCH() {
		JSONObject request = new JSONObject()
		request.put("lastName", "Willey")
		
		RequestSpecification httpRequest=RestAssured.given()
		httpRequest.contentType(ContentType.JSON)
		httpRequest.accept(ContentType.JSON)
		httpRequest.body(request.toJSONString())
		
		Response response=httpRequest.put("/users/5")
		JsonPath jsonPathEvaluator = response.jsonPath()
		String lastName=jsonPathEvaluator.get("lastName")
		httpRequest.then().statusCode(200)
		Assert.assertTrue(lastName.equals("Willey"))
	}
	@Test
	void test_DELETE() {
		Response responseBefore=RestAssured.given().get("/users")
		JsonPath jpBefore = responseBefore.jsonPath()
		List<Users> users= jpBefore.getList("users", Users.class)
		RestAssured.delete("/users/5").then().statusCode(200)
		Response responseAfter=RestAssured.given().get("/users")
		JsonPath jpAfter = responseAfter.jsonPath()
		List<Users> users1= jpAfter.getList("users", Users.class)
		int listSizeBefore=users.size()
		int listSizeAfter=users1.size()
		Assert.assertTrue(listSizeBefore>listSizeAfter)
	}

}
