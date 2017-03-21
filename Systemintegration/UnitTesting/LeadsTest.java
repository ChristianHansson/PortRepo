package UnitTesting;

import static org.junit.Assert.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.junit.Test;

import App.ErrorHandling;
import App.Leads;

public class LeadsTest {

	private ServerConnectionCloneClass serverCon = new ServerConnectionCloneClass();
	private ErrorHandling eh = new ErrorHandling();
	//private Leads leads = new Leads();
	@Test
	public void test() {
		//fail("Not yet implemented");
		//Document elXml = serverCon.getXmlFromLeads();
		//assertNotNull(elXml);
		//System.out.println(elXml.getFirstChild().getFirstChild().getTextContent());
		//eh.addLeadsList(elXml); //dummy datan skapar error i nuläget
		//System.out.println(eh.leads.dict.keySet());
	}
}
