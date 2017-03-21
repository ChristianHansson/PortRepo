package UnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import App.properties.*;

public class PropertiesTest {	

	private LeadProperties leadProperties = new LeadProperties();
	//Hittar inget sätt att testa mailProperties. För dåligt kommenterat så jag förstår inte hur den funkar.
	@SuppressWarnings("unused")
	private MailProperties mailProperties = new MailProperties();
	private ScheduleProperties scheduleProperties = new ScheduleProperties();
	private ServerProperties serverproperties = new ServerProperties();

	@Test
	public void test() {
		assertNotNull(leadProperties.maxLeads().get());
		assertNotNull(leadProperties.minLeads().get());
		System.out.println("LeadProperties testad");
		System.out.println("MailProperties ej testad");
		assertNotNull(scheduleProperties.runTime().get());
		assertNotNull(scheduleProperties.next());
		System.out.println("ScheduleProperties testad");
		assertNotNull(serverproperties.token().get());
		assertNotNull(serverproperties.url().get());
		System.out.println("ServerProperties testad");
	}
}
