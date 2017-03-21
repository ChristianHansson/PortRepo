package UnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;
import org.w3c.dom.Document;

import App.ErrorHandling;

public class checkOldListTest {

	private ErrorHandling errhan = new ErrorHandling();
	private ServerConnectionCloneClass scClone = new ServerConnectionCloneClass();
	private Document doc;
	
	@Test
	public void test() {
		doc = scClone.getXmlWithoutError();
		errhan.checkOldList(doc);
	}

}
