package demo;
import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
public class POC {
	@Test
	public void test_GET() {
		baseURI="http://localhost:3000/";
		RequestSpecification httpRequest = RestAssured.given();

	    Response response = httpRequest.get("/users");
	    
	    ResponseBody body = response.getBody();
	    
	    String bodyStringValue = body.asString();
	    
	    // Get JSON Representation from Response Body 
	    JsonPath jsonPathEvaluator = response.jsonPath();

	    // Get specific element from JSON document 
	    String firstName = jsonPathEvaluator.get("firstName[1]");
	    
	    int statusCode = response.getStatusCode();
	    
	    

	    // Validate if the specific JSON element is equal to expected value
	    Assert.assertTrue(firstName.equalsIgnoreCase("Mohammed"));
	    Assert.assertEquals(200, statusCode);
	}


}
