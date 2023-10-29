package org.rest.com;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
public class GetMethod {
@Test	
public void getMethod() {
	String url="https://reqres.in/api/users?page=2";		
	Response res=get(url);
	System.out.println(res.getBody().asPrettyString());
		
 }
@Test
public void getInBDDWay() {
	baseURI="https://reqres.in/api/users/340";
	
	given()
	.when().get().then().statusCode(200).log().body();
}
}
