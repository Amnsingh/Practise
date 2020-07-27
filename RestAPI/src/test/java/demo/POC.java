package demo;
import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
public class POC {
	final static String uri ="http://localhost:3000/";

	//@Test
	public void test_GET() {
		baseURI=uri;
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get("/users");

		JsonPath jsonPathEvaluator = response.jsonPath();

		String firstName = jsonPathEvaluator.get("firstName[1]");

		int statusCode = response.getStatusCode();



		Assert.assertTrue(firstName.equalsIgnoreCase("Graham"));
		Assert.assertEquals(200, statusCode);
	}
	//@Test
	public void test_POST() {
		JSONObject request = new JSONObject();
		request.put("firstName", "Dennis");
		request.put("lastName", "Ritchie");
		request.put("subjectId", 1);

		baseURI=uri;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		httpRequest.accept(ContentType.JSON);
		httpRequest.body(request.toJSONString());

		Response response = httpRequest.post("/users");
		
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
		baseURI=uri;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		httpRequest.accept(ContentType.JSON);
		httpRequest.body(request.toJSONString());

		Response response = httpRequest.put("/users/1");
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
		baseURI=uri;
		 RequestSpecification httpRequest = RestAssured.given();
		    httpRequest.contentType(ContentType.JSON);
		    httpRequest.accept(ContentType.JSON);
		    httpRequest.body(request.toJSONString());
		    
		    Response response = httpRequest.patch("/users/2");
		    
		    int statusCode = response.getStatusCode();
		    JsonPath jsonPathEvaluator = response.jsonPath();
		    String firstName = jsonPathEvaluator.get("lastName");
		    Assert.assertTrue(firstName.equalsIgnoreCase("Sharma"));
		    Assert.assertEquals(200, statusCode);
		    System.out.println(statusCode);
	}

	@Test
	public void test_DELETE() {
		baseURI=uri;
		RequestSpecification httpRequest = RestAssured.given();
		Response responseBefore = httpRequest.get("/users");

		JsonPath jsonPathEvaluatorBefore = responseBefore.jsonPath();

		List<Users> allUsersBefore = jsonPathEvaluatorBefore.getList("users", Users.class);

	
		int sizeBefore=allUsersBefore.size();
		int statusId=httpRequest.delete("/users/5").getStatusCode();
		Response responseAfter = httpRequest.get("/users");
		JsonPath jsonPathEvaluatorAfter = responseAfter.jsonPath();
		List<Users> allUsersAfter = jsonPathEvaluatorAfter.getList("users", Users.class);
		int sizeAfter=allUsersAfter.size();
		Assert.assertEquals(200, statusId);
		Assert.assertTrue(sizeBefore>sizeAfter);
		System.out.println(sizeBefore);
		System.out.println(sizeAfter);
	}
}
