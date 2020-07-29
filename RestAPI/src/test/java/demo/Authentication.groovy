package demo
import static io.restassured.RestAssured.* 

import org.junit.Test
class Authentication {
	@Test
	void testBasicPremptiveAuthentication1() {
		given().
		auth().
		preemptive().
		basic("username", "password").
		when().
		get("http://localhost:3000/users").
		then().
		statusCode(200)
	}
	@Test
	void testBasicChallengedAuthentication() {
		given().
		auth().
		basic("userName", "password").
		when().
		get("http://localhost:3000/users").
		then().
		statusCode(200)
	}
	@Test
	void testDigestiveAuthentication() {
		given().
		auth().
		digest("userName", "password").
		when().
		get("http://localhost:3000/users").
		then().
		statusCode(200)
	}
}
