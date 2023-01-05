package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC01_GetAllEmpDetails extends TestBase{
	
	@BeforeClass
	void getAllEmp()	{
		logger.info("-----Get all-----");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employees");
		System.out.println(response.getBody().asString());
	}
	
	@Test
	void validateResponseBody()	{
		Assert.assertTrue(false);
		Assert.assertEquals(response.getBody().asString().contains("Quinn Flynn"), true);
	}

}
