package DemoPackage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1 
{
	@Test
	void DemoAPITest()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/hyderabad");
		
		String jsonResponse = response.getBody().asString();
		System.out.println("The Json Response is: "+jsonResponse);	
	}
}
