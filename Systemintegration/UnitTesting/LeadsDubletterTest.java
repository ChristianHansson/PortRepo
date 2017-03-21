package UnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;
import org.w3c.dom.Document;

import App.ErrorHandling;

public class LeadsDubletterTest {

	private ServerConnectionCloneClass scClone = new ServerConnectionCloneClass();
	private ErrorHandling errhan = new ErrorHandling();
	private Document doc;
	
	@Test
	public void test() {
		int expectedleadCount = 98;
		doc = scClone.getXmlWithDuplicates();
		errhan.addLeadsList(doc);
		assertEquals(expectedleadCount, errhan.countLeads());
	}

}
