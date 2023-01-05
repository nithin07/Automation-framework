package api.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import api.utilities.GlobalConfig;
import api.utilities.JiraServiceProvider;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	
	public static Logger logger;
	
	@BeforeClass
	public void setup() {
		
		logger= Logger.getLogger("EmplyeRestAPI");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
		JiraServiceProvider jiraSp = new JiraServiceProvider("https://nithinshettyautomation.atlassian.net/", "nithinshetty063@gmail.com", "9udcQH6xkVKvdxekvOz38190", "TES");
		GlobalConfig.test_execution= jiraSp.createJiraTicket("Test execution", "Test Execution 1", "Testing Descriptipn", "Nithin");
		
	}
	
	

}
