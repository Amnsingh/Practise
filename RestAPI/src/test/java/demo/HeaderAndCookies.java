package demo;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

import static io.restassured.path.json.JsonPath.*;
public class HeaderAndCookies {
	
	//Extract details as String and fetching further details w/o using json path
	@Test
	public void testJsonPath() {
	String responseAsString=
		when().
			get("http://jsonplaceholder.typicode.com/photos").
		then().
		extract().asString();
		
	List<Integer> albumIds = from(responseAsString).get("id");
	System.out.println(albumIds.size());
	}
	//To get response header
	//@Test
	public void testResponseHeaders() {
		Response response = get("http://jsonplaceholder.typicode.com/photos");
		
		//to get a single header
		String headerCFRAY = response.getHeader("CF-Ray");
		System.out.println(">>>>>>Header: "+headerCFRAY);
		
		System.out.println("");
		
		//to get all header
		Headers headers = response.getHeaders();
		for(Header h: headers) {
			System.out.println(h.getName()+":"+h.getValue());
		}
	}
	//to get cookies
	//@Test
	public void testCookies() {
		Response response = get("http://jsonplaceholder.typicode.com/photos");
		Map<String, String> cookies = response.getCookies();
		
		for(Map.Entry<String, String> entry : cookies.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
	//to get detailed cookies
	@Test
	public void testDetailedCookies() {
		Response response = get("http://jsonplaceholder.typicode.com/photos");
		
		Cookie o = response.getDetailedCookie("__cfduid");
		
		System.out.println("Detailed: "+o.hasExpiryDate());
		System.out.println("Detailed: "+o.getExpiryDate());
		System.out.println("Detailed: "+o.hasValue());
	}
}
