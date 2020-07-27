package demo;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_ValidateHeaders {
	@Test
	private void headerValidation() {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "http://localhost:3000/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users");
		String contentLength=response.getHeader("Content-Length");
		System.out.println(contentLength);
		Assert.assertEquals(contentLength, "374");
		String contentType = response.getHeader("Content-Type");
		System.out.println(contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
	}
}
