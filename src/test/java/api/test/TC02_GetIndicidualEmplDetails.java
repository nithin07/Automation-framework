package api.test;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC02_GetIndicidualEmplDetails extends TestBase {
	
	public static String empID = "12";
	@BeforeClass
	void getIndividualEmpDetails()	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "employee/"+empID);
	}
	
	@Test
	void validateEmpID	()	{
		Assert.assertEquals(response.getBody().asString().contains(empID), true);
	}

	@Test
	void validateStatusCode()	{
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
	}
}
