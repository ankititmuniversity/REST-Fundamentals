package org.rest.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HeadersMethodTest {
	@Test
	public void test01() {
		//https://reqres.in/api/users?page=1

		Header header1=new Header("Header1", "Value1");

		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.baseUri("https://reqres.in/api/users?page=1");

		reqSpec.header(header1);
		reqSpec.log().headers();
		reqSpec.get();

	}
	@Test
	public void test02() {
		Header header1=new Header("HeaderKey1","Value1");
		Header header2=new Header("HeaderKey2","Value2");
		Header header3=new Header("HeaderKey3","Value3");

		List<Header> headerList=new ArrayList<Header>();
		headerList.add(header1);
		headerList.add(header2);
		headerList.add(header3);

		Headers headers=new Headers(headerList);
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.baseUri("https://reqres.in/api/users?page=1");

		reqSpec.headers(headers);
		reqSpec.log().headers();
		reqSpec.get();
	}
	@Test
	public void test03() {
		Map<String,String> headersMap=new HashMap<String,String>();
		headersMap.put("Header1", "Value1");
		headersMap.put("Header2", "Value2");
		headersMap.put("Header3", "Value3");
		
		//Headers headers=new Headers(headerList);
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.baseUri("https://reqres.in/api/users?page=1");

		reqSpec.headers(headersMap);
		reqSpec.log().headers();
		reqSpec.get();
		
	}
	@Test
	public void test04() {
		Map<String,String> headersMap=new HashMap<String,String>();
		headersMap.put("Header11", "Value1");
		headersMap.put("Header22", "Value2");
		headersMap.put("Header33", "Value3");
		
		RestAssured
		.given()
			.headers(headersMap)
			.log().headers()
		.when()			
			.get("https://reqres.in/api/users?page=1")	
		.then()
			.log()
			.body();
	}
}
