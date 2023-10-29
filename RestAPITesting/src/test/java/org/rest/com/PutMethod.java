
package org.rest.com;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutMethod {
@Test
public void test() {
	JSONObject jsonData=new JSONObject();
	jsonData.put("name", "Tuddi");
	jsonData.put("job", "Professor");
	
	RestAssured.baseURI="https://reqres.in/api/users/340";
	RestAssured.given()
	.header("Content-type","application/json")
	.contentType(ContentType.JSON)
	.body(jsonData.toJSONString())
	.when().put()
	.then().statusCode(200).log().all();
}
}
