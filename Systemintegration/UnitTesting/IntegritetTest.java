package UnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;
import org.w3c.dom.Document;

import App.ErrorHandling;
import App.Leads;

public class IntegritetTest {

	private ServerConnectionCloneClass scClone = new ServerConnectionCloneClass();
	private ErrorHandling errhan = new ErrorHandling();
	private Leads leads = new Leads();
	private Document doc;
	
	@Test
	public void test() {
		int exptectedCount = 100;
		//doc = sc.getXmlFromLeads();
		//doc = scClone.getXmlWithoutError();
		//doc = scClone.getXmlWithError();
		//doc = scClone.getXmlTenThousand();
		//doc = scClone.getXmlWithSqlAndJs();
		doc = scClone.getXmlCorruptName();
		//doc = scClone.getXmlCorruptEmail();
		assertNotNull(doc);
		errhan.addLeadsList(doc);
		errhan.logInvalidNames();
		assertNotEquals(exptectedCount, errhan.countLeads());
		//System.out.println(errhan.countLeads());
	}

}
