package UnitTesting;

import static org.junit.Assert.*;

import org.hamcrest.*;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.w3c.dom.Document;

import App.AppException;
import App.ErrorHandling;
import App.Logger;
import App.ServerConnection;
import App.Severity;
import App.AppException.ErrorCode;

public class getLeads {

	private ErrorHandling errHan = new ErrorHandling();
	private ServerConnectionCloneClass scClone = new ServerConnectionCloneClass();
	private ServerConnection sc = new ServerConnection();
	private Document doc;
	
	@Test 
	public void test() {
		//doc = sc.getXmlFromLeads();
		//doc = scClone.getXmlWithoutError();
		//doc = scClone.getXmlWithError();
		doc = scClone.getXmlTenThousand();
		errHan.addLeadsList(doc);
		System.out.println(errHan.countLeads());
		assertNotNull(errHan.countLeads());
		//errHan.checkSLA();
	}	
	
}
