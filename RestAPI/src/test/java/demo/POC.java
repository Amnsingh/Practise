package demo;
import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
public class POC {
	//@Test
	public void test_GET() {
		baseURI="http://localhost:3000/";
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get("/users");

		ResponseBody body = response.getBody();


		// Get JSON Representation from Response Body 
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Get specific element from JSON document 
		String firstName = jsonPathEvaluator.get("firstName[1]");

		int statusCode = response.getStatusCode();



		// Validate if the specific JSON element is equal to expected value
		Assert.assertTrue(firstName.equalsIgnoreCase("Mohammed"));
		Assert.assertEquals(200, statusCode);
	}
	//@Test
	public void test_POST() {
		JSONObject request = new JSONObject();
		request.put("firstName", "Dennis");
		request.put("lastName", "Ritchie");
		request.put("subjectId", 1);

		baseURI="http://localhost:3000/";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		httpRequest.accept(ContentType.JSON);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(request.toJSONString());

		Response response = httpRequest.post("/users");
		
		//httpRequest.post("/users").then().statusCode(200);

		ResponseBody body = response.getBody();
		JsonPath jsonPathEvaluator = response.jsonPath();
		String firstName = jsonPathEvaluator.get("firstName");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(201, statusCode);
		Assert.assertTrue(firstName.equalsIgnoreCase("Dennis"));


	}
	//@Test
	public void test_PUT() {
		JSONObject request = new JSONObject();
		request.put("firstName", "Issac");
		request.put("lastName", "Newton");
		request.put("subjectId", 1);		
		baseURI="http://localhost:3000/";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		httpRequest.accept(ContentType.JSON);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(request.toJSONString());

		Response response = httpRequest.put("/users/1");

		ResponseBody body = response.getBody();
		JsonPath jsonPathEvaluator = response.jsonPath();
		String firstName = jsonPathEvaluator.get("firstName");
		int statusCode= response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		Assert.assertTrue(firstName.equalsIgnoreCase("Issac"));

	}
	//@Test
	public void test_PATCH() {
		JSONObject request = new JSONObject();
		request.put("lastName", "Sharma");
		baseURI="http://localhost:3000/";
		 RequestSpecification httpRequest = RestAssured.given();
		    httpRequest.contentType(ContentType.JSON);
		    httpRequest.accept(ContentType.JSON);
		    httpRequest.header("Content-Type","application/json");
		    httpRequest.body(request.toJSONString());
		    
		    Response response = httpRequest.patch("/users/2");
		    
		    int statusCode = response.getStatusCode();
		    ResponseBody body = response.getBody();
		    JsonPath jsonPathEvaluator = response.jsonPath();
		    String firstName = jsonPathEvaluator.get("lastName");
		    Assert.assertTrue(firstName.equalsIgnoreCase("Sharma"));
		    Assert.assertEquals(200, statusCode);
		    System.out.println(statusCode);
	}
	@Test
	public void test_DELETE() {
		baseURI="http://localhost:3000/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.delete("/users/4");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		httpRequest.get("/users").then()
		.body((containsString("4")));

	}


}
