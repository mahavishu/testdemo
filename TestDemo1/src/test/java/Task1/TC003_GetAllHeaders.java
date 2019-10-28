package Task1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GetAllHeaders 
{
	@Test
	public void getAllHeaders()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		String responseBody = response.getBody().asString();
		System.out.println("The Response Body is: "+responseBody);
		
		Headers allHeader = response.getHeaders();
		
		for(Header header: allHeader)
		{
			System.out.println(header.getName()+ " = "+header.getValue());
		}
	}
}
