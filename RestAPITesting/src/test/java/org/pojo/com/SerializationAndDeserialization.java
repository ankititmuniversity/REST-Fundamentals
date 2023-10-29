package org.pojo.com;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SerializationAndDeserialization {
	
	@Test
	public void serialTest() throws JsonProcessingException {
		Employee emp1=new Employee();
		emp1.setFname("Aman");
		emp1.setLname("Gupta");
		emp1.setAge(28);
		emp1.setGeneder("Male");
		emp1.setSalary(100000);
		
		//Converting Employee class object into JSON Object
		 ObjectMapper objectMapper=new ObjectMapper();
		String empJsonObjForm= objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println(empJsonObjForm);
		
		//Use of the above data i.e "empJsonObjForm"
		
		RequestSpecification reqSpec=RestAssured.given();
		Response response=reqSpec.baseUri("http://httpbin.org")
		.basePath("/post")
		.contentType(ContentType.JSON)
		.body(empJsonObjForm)
		.post();
		
		response.prettyPrint();
		System.out.println("Response code : "+response.getStatusCode());
		
		//Converting JSON Object into Employee class object
		Employee emp2=objectMapper.readValue(empJsonObjForm, Employee.class);
		System.out.println("*************Deserialization****************");
		System.out.println("First Name is - "+emp2.getFname());
		System.out.println("Last Name is - "+emp2.getLname());
		System.out.println("Gender is - "+emp2.getGeneder());
		System.out.println("Age is - "+emp2.getAge());
		System.out.println("Salary is - "+emp2.getSalary());
		
		
		
		
		
	}

}
