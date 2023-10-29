package org.rest.com;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UseOfMapCollection {
	
	RequestSpecification reqSpec=RestAssured.given();
@Test
public void createToken() {
	
	Map<String,String> payload= new HashMap<String,String>();
	payload.put("username", "admin");
	payload.put("password", "password123");
	
	Response response=reqSpec.baseUri("https://restful-booker.herokuapp.com")
	.basePath("/auth")
	.contentType(ContentType.JSON)
	.header("Content-Type", "application/json")
	.body(payload)
	.post();
	
	System.out.println(response.asPrettyString());
	
}
}
