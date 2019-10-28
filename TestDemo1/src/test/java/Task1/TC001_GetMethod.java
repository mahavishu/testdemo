package Task1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_GetMethod 
{
	@Test
	public void getWeatherDetails()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		String responseBody = response.getBody().asString();
		System.out.println("The Response Body is: "+responseBody);
		
		int statusCode = response.statusCode();
		System.out.println("The Status Code is: "+statusCode);
		Assert.assertEquals(200,statusCode);
		
		String statusLine = response.statusLine();
		System.out.println("The Status Line is: "+statusLine);
		Assert.assertEquals("HTTP/1.1 200 OK",statusLine);
		
		String contentType = response.getHeader("Content-Type");
		System.out.println("The Content-Type is: "+contentType);
		Assert.assertEquals("application/json",contentType);
		
		double responseTime = response.getTime();
		System.out.println("The Response Time is: "+responseTime);
				
	}
}
