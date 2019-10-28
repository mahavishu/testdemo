package Task1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.PreemptiveAuthSpecImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC006_Authenticate 
{
	@Test
	public void authenticate()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/");
		
		String responseBody = response.getBody().asString();
		System.out.println("The Response Body is: "+responseBody);
		
		int statusCode = response.getStatusCode();
		System.out.println("The Status Code is: "+statusCode);
		Assert.assertEquals(200,statusCode);
	}
}
