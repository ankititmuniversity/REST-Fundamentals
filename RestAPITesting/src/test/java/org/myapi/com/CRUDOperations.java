package org.myapi.com;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUDOperations {
	@BeforeClass
	public void setUp() {
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.baseUri("http://localhost:3000");
		reqSpec.basePath("/users");	
		RestAssured.requestSpecification=reqSpec;
	}


	@Test(priority=-1,enabled=false)
	public void bodyScan() {

		Response response=RestAssured.get();

		System.out.println("Response Body is : "+response.getBody().asPrettyString());
	}
	@Test(priority=0,enabled=false)
	public void creatTest() {
		Map<String,Object>payload=new HashMap<>();
		payload.put("id", 5);
		payload.put("name", "Rahul");
		payload.put("age",25);


		Response response=RestAssured.given().header("Content-Type", "application/json").
				contentType(ContentType.JSON).
				body(payload).
				post();

		System.out.println("Response body is : "+response.getBody().asPrettyString());
		System.out.println("Response code is : "+response.getStatusCode());



	}
	@Test(priority=4)
	public void readTest() {

		Response response=RestAssured.get();

		System.out.println("Response Body is : "+response.getBody().asPrettyString());
	}
	@Test(priority=2,enabled=false)
	public void updateTest() {
		Map<String,Object>payload=new HashMap<>();
		payload.put("id", 5);
		payload.put("name", "Rahul Kumar");
		payload.put("age", 15);



		Response response=RestAssured.given().header("Content-Type", "application/json").
				contentType(ContentType.JSON).
				body(payload).
				patch("/5");

		System.out.println("Response body is : "+response.getBody().asPrettyString()+ " after Update");
		System.out.println("Response code is : "+response.getStatusCode()+ " after update");
	}
	@Test(priority=3)
	public void deleteTest() {
		Response response=RestAssured.delete("/4");
		System.out.println("Response code is : "+response.getStatusCode()+ " after delete operation");
		System.out.println("Response Body is : "+response.getBody().asPrettyString()+" after delete operation");
	}
}
