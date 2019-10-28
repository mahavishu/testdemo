package Task1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC005_GetResponseAttribute 
{
	@Test
	public void getResponseBody()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		String responseBody = response.getBody().asString();
		System.out.println("The Response Body is: "+responseBody);
		
		JsonPath jPath = response.jsonPath();
		
		System.out.println(jPath.get("City"));
		System.out.println(jPath.get("Temperature"));
		System.out.println(jPath.get("Humidity"));
		System.out.println(jPath.get("WeatherDescription"));
		System.out.println(jPath.get("WindSpeed"));
		System.out.println(jPath.get("WindDirectionDegree"));
		
		Assert.assertEquals("Hyderabad",jPath.get("City"));
		
	}
}
