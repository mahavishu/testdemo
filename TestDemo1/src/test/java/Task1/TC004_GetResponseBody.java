package Task1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC004_GetResponseBody 
{
	@Test
	public void getResponseBody()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		String responseBody = response.getBody().asString();
		System.out.println("The Response Body is: "+responseBody);
		
		Assert.assertEquals(true,responseBody.contains("Hyderabad"));
		Assert.assertEquals(true,responseBody.contains("29.35 Degree celsius"));
		Assert.assertEquals(true,responseBody.contains("79 Percent"));
		Assert.assertEquals(true,responseBody.contains("haze"));
		Assert.assertEquals(true,responseBody.contains("3.1 Km per hour"));
		Assert.assertEquals(true,responseBody.contains("120 Degree"));
		
	}
	
}
