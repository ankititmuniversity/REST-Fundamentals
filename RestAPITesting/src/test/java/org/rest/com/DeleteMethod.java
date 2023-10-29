package org.rest.com;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteMethod {
@Test
public void test() {
	RestAssured.baseURI="https://reqres.in/api/users/340";
	RestAssured.
	given().
	when() 
		.delete().
	then()
		.statusCode(204).
	log().all();
}
}
