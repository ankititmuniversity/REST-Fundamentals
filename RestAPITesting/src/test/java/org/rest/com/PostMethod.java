package org.rest.com;

import org.json.simple.JSONObject;
import org.testng.annotations.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class PostMethod {
@Test
public void test01() {
	JSONObject jsonData=new JSONObject();
	jsonData.put("name", "Rahul");
	jsonData.put("job", "Professor");
	
	RestAssured.baseURI="https://reqres.in/api/users";
	RestAssured.given()
	.header("Content-type","application/json")
	.contentType(ContentType.JSON)
	.body(jsonData.toJSONString())
	.when().post()
	.then().statusCode(201).log().all();
	
}
}
