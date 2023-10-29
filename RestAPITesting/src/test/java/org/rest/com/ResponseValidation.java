package org.rest.com;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseValidation {

	
	@Test
	public void test() {
	RestAssured.baseURI="https://reqres.in/api/users/2";
	
	RequestSpecification requestSpec= RestAssured.given();
	
	Response res=requestSpec.get();
	
	int actualStatusCode=res.statusCode();
	Assert.assertEquals(actualStatusCode, 200,"Result Validated");
	
	}
}
