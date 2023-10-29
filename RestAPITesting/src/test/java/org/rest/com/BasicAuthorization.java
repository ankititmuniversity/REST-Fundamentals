package org.rest.com;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuthorization {
RequestSpecification reqSpec=RestAssured.given();
@Test
public void test01() {
	//RequestSpecification reqSpec=RestAssured.given();
	reqSpec.baseUri("https://postman-echo.com");
	reqSpec.basePath("/basic-auth");
	 
	Response response=reqSpec.auth().basic("postman", "password").get();
	System.out.println("Response Status Code : "+response.statusCode());
	//https://httpbin.org/
	
}
@Test
public void test02() {
	//Digest Authentication
	//RequestSpecification reqSpec=RestAssured.given();
	reqSpec.baseUri("https://httpbin.org");
	reqSpec.basePath("/digest-auth/undefined/ankit/ankit");
	 
	Response response=reqSpec.auth().digest("ankit", "ankit").get();
	System.out.println("Digest-Auth Response Status Code : "+response.statusCode());
	System.out.println("Digest Auth Response Body : "+ response.getBody().asPrettyString());
	//https://httpbin.org/
	
}

@Test
public void test03() {
	//Bearer Token Authentication
	//RequestSpecification reqSpec=RestAssured.given();
	reqSpec.baseUri("https://gorest.co.in");
	reqSpec.basePath("/public/v2/users");
	
	JSONObject jsonData=new JSONObject();
	jsonData.put("name", "Ankit");
	jsonData.put("gender", "Male");
	jsonData.put("email", "abc@xyx.com");
	jsonData.put("status", "Active");
	
	String AuthToken="Bearer 4c7c2486f22d6b2ddbe7dea140edb552f34db2fc2c68d3ded009972227e81ec3";
	Response response=reqSpec
			.headers("Authorization", AuthToken)
			.contentType(ContentType.JSON)			
			.body(jsonData.toJSONString())
			.post();
	System.out.println("Bearer Token-Auth Response Status Code : "+response.statusCode());
	System.out.println("Bearer Token-Auth Response Body : "+ response.getBody().asPrettyString());
	//https://httpbin.org/
	
}
}
