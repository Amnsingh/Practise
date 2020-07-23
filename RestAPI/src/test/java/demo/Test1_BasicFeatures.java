package demo;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test1_BasicFeatures {
	//simply checking status code
	//@Test
	public void testStatusCode() {
		given().
			get("http://jsonplaceholder.typicode.com/posts/3").
		then().
			statusCode(200);
	}
	//it will verify status code and print complete response in console
		//@Test
		public void testlogging() {
			given().
				get("http://jsonplaceholder.typicode.com/posts/3").
			then().
				statusCode(200).
				log().all();
		}
	//verifying single content using org.hamcrests.Matchers library's equalTo method
	//@Test
	public void testEqualToFunction() {
		given().
		get("https://reqres.in/api/users?page=2").
	then().
		statusCode(200).
		body("data.id[1]",equalTo(8)).
		body("data.first_name",hasItems("Michael","Lindsay")).
		log().all();
	}
	//@Test
	public void testWithRoot() {
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			root("data").
			body("id[1]",Matchers.is(8)).
			log().all();
	}
	//@Test
		public void testDetachRoot() {
			given().
				get("https://reqres.in/api/users?page=2").
			then().
				root("data").
				body("id[1]",Matchers.is(8)).
				detachRoot("data").
				body("data.id[1]",Matchers.is(8)).
				log().all();
		}
		@Test
		public void testExtract() {
			String href=
			when().
				get("http://jsonplaceholder.typicode.com/photos/1").
			then().
				contentType(ContentType.JSON).
				body("albumId",Matchers.equalTo(1)).
			extract().
				path("url");
			System.out.println(href);
			
			when().get(href).
				then().
			statusCode(200);
		}
		
	
}
