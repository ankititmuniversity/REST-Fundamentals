package org.rest.com;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.RestAssured;

public class PatchMethod {
@Test
public void test() {
	RestAssured.baseURI="https://reqres.in/api/users/340";
	
	JSONObject jsonData=new JSONObject();
	jsonData.put("name", "Tuddi");
	jsonData.put("job", "Professoreeeeeeee");
	
	RestAssured.given()
	.header("Content-type","application/json")
	.contentType(ContentType.JSON)
	.body(jsonData.toJSONString())
	.when().patch()
	.then().statusCode(200).log().all();
}
}
