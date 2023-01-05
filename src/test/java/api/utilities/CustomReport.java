package api.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import api.base.TestBase;
import net.rcarz.jiraclient.Field;

public class CustomReport extends TestBase implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult arg0)	{
		System.out.println("Started");
		TestBase.logger.info("Test case Failed");
		JiraServiceProvider jiraSp = new JiraServiceProvider("https://nithinshettyautomation.atlassian.net/", "nithinshetty063@gmail.com", "9udcQH6xkVKvdxekvOz38190", "TES");
		jiraSp.createJiraTicket("Bug", "TES", "Testing Descriptipn", "Nithin");
		//jiraSp.updateIssue();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Started Execution");
		TestBase.logger.info("Test case Started");
		JiraServiceProvider jiraSp = new JiraServiceProvider("https://nithinshettyautomation.atlassian.net/", "nithinshetty063@gmail.com", "9udcQH6xkVKvdxekvOz38190", "TES");
		String ticketNumber = jiraSp.createJiraTicket("Test", "Test case 1", "Testing Descriptipn", "Nithin");
		jiraSp.updateIssue(ticketNumber, Field.COMPONENTS, ticketNumber);
	}


}
