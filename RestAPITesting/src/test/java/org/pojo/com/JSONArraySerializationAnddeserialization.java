package org.pojo.com;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class JSONArraySerializationAnddeserialization {
	@Test
	public void objectListCreationTest() throws JsonProcessingException {
		Employee emp1=new Employee();
		emp1.setFname("Aman");
		emp1.setLname("Gupta");
		emp1.setAge(28);
		emp1.setGeneder("Male");
		emp1.setSalary(100000);

		Employee emp2=new Employee();
		emp2.setFname("Vishnu");
		emp2.setLname("Sarkar");
		emp2.setAge(28);
		emp2.setGeneder("Male");
		emp2.setSalary(105000);

		Employee emp3=new Employee();
		emp3.setFname("Summer");
		emp3.setLname("Sharma");
		emp3.setAge(28);
		emp3.setGeneder("Male");
		emp3.setSalary(110000);

		List<Employee> empList=new ArrayList<Employee>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);

		ObjectMapper empListPayload=new ObjectMapper();
		String empListJsonForm=empListPayload.writerWithDefaultPrettyPrinter().writeValueAsString(empList);

		System.out.println("Json Data Form of Employee Class object is : "+empListJsonForm);
		System.out.println("***********************************************************");
		//Use of the above data i.e "empJsonObjForm"

		RequestSpecification reqSpec=RestAssured.given();
		Response response=reqSpec.baseUri("http://httpbin.org")
				.basePath("/post")
				.contentType(ContentType.JSON)
				.body(empListJsonForm)
				.post();

		response.prettyPrint();
		System.out.println("Response code : "+response.getStatusCode());

		//Converting JSON Object into Employee class object i.e Deserialization
		ResponseBody rBody=response.getBody();
		JsonPath jsonPathView=rBody.jsonPath();
		List<Employee> allEmployees=jsonPathView.getList("json",Employee.class);
		for(Employee emp:allEmployees) {
			System.out.println(emp.getFname()+" "+emp.getLname());
		}
	}
}
