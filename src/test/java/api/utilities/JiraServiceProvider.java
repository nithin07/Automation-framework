package api.utilities;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Component;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.Issue.FluentUpdate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider {

	public JiraClient jiraClient;
	public String project;
	
	public JiraServiceProvider(String jiraUrl, String username, String password, String project)		{
		BasicCredentials cred = new BasicCredentials(username, password);
		jiraClient = new JiraClient(jiraUrl, cred);
		this.project = project;
		System.out.println("Inside Constructor of JSP");
	}
	

	
	public String createJiraTicket(String issueType, String summary, String description, String reporterName)	{
		Issue newIssue = null;
		try {
			FluentCreate fluentCreate = jiraClient.createIssue(project, issueType);
			fluentCreate.field(Field.SUMMARY, summary);
			fluentCreate.field(Field.DESCRIPTION, description);
//			fluentCreate.field(reporterName, fluentCreate)
			newIssue = fluentCreate.execute();
			System.out.println("New issue created : "+newIssue);
			return newIssue.toString();
		} catch (JiraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newIssue.toString();
	}
	
	public void updateIssue(String ticketNumber, String field_name, String newValue)	{
		try {
			Issue issue = jiraClient.getIssue(ticketNumber);
			//Component c = jiraClient.getComponent("TE-11");
			System.out.println("Componet:"+issue.getComponents().size());
			issue.link("TES-11", "Test execution");
			FluentUpdate f = issue.update().field(field_name, newValue);
			f.execute();
		} catch (JiraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
