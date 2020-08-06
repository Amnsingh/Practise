package demo

import org.junit.Test

import io.restassured.RestAssured
import io.restassured.path.json.JsonPath
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification


class JSONArrayToList {
	@Test
	void test_JSONArrayToList() {
		RestAssured.baseURI="https://reqres.in/api/users?page=2"
		RequestSpecification httpRequest = RestAssured.given()
		Response response = httpRequest.get()
		JsonPath JSONPathEvaluator = response.jsonPath()
		
		List<String> allEmails = JSONPathEvaluator.getList("data.email")
		for(String mails:allEmails) {
			println("Mail :"+mails)
		}
	}
}
