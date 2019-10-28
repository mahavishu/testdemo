package Task1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_PostMethod 
{
	@SuppressWarnings("unchecked")
	@Test
	public void register()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParam = new JSONObject();
		
		requestParam.put("FirstName","Ram3");
		requestParam.put("LastName","Kumar3");
		requestParam.put("UserName","ramkumar3");
		requestParam.put("Password","ram12345113");
		requestParam.put("Email","ram3@gmail.com");
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestParam.toJSONString());
		
		Response response = httpRequest.request(Method.POST,"/register");
		
		String responeBody = response.getBody().asString();
		System.out.println("The Response Body is: "+responeBody);
		
		int statusCode = response.statusCode();
		System.out.println("The Status Code is: "+statusCode);
		Assert.assertEquals(201,statusCode);
		
		String successCode = response.jsonPath().get("SuccessCode");
		System.out.println("The Success Code is: "+successCode);
		Assert.assertEquals("OPERATION_SUCCESS",successCode);
		
		String message = response.jsonPath().get("Message");
		System.out.println("The Success Message is: "+message);
		Assert.assertEquals("Operation completed successfully",message);
	}
	
}
