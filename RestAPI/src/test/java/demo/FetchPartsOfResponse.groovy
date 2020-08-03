package demo

import static org.junit.Assert.*

import java.util.concurrent.TimeUnit

import org.junit.Before
import org.junit.Test

import io.restassured.RestAssured
import io.restassured.http.Header
import io.restassured.http.Headers

class FetchPartsOfResponse {
	@Before
	void setBaseURI() {
		RestAssured.baseURI = "http://localhost:3000/"
	}
	@Test
	void test_fetchHeaders() {
		Headers headers = RestAssured.when().get("/users").then().extract().headers()
		for(Header h : headers) {
			println("Name "+h.getName()+" Value "+h.getValue())
		}
	}
	//@Test
	void getSpecificPart() {
		List<String> firstName = RestAssured.when().get("/users").then().extract().path("firstName")
		for(String f : firstName) {
			println("First Name :"+f)
		}
	}
	//@Test
	void fetchResponseTime() {
		Long responseTime = RestAssured.when().get("/users").timeIn(TimeUnit.MILLISECONDS)
		print("The response time is:"+responseTime)
	}
}
