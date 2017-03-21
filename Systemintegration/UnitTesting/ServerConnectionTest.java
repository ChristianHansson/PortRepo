package UnitTesting;

import static org.junit.Assert.*;

import java.io.*;
import java.net.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.junit.Test;

import UnitTesting.ServerConnectionCloneClass;
import static org.hamcrest.CoreMatchers.*;
import App.ServerConnection;

public class ServerConnectionTest {

	private ServerConnection sc = new ServerConnection();
	private ServerConnectionCloneClass sc_clone =  new ServerConnectionCloneClass();
	
	@Test 
	public void test() {
		assertNotNull("Den är inte null",sc.getXmlFromLeads());
		try {
			assertNotNull(sc.getStringFromServer());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println(sc.getXmlFromLeads().getFirstChild().getFirstChild().getTextContent());
		
	}
	
	@Test
	public void testCloneClass(){
		//System.out.println(sc_clone.getXmlFromLeads().getFirstChild().getFirstChild().getTextContent());
		//System.out.println(sc_clone.getStringFromServer());
		//System.out.print(sc_clone.getXmlFromLeads().getFirstChild().getTextContent());
		assertNotNull(sc_clone.getXmlWithoutError());
		assertNotNull(sc_clone.getXmlWithError());
		assertNotNull(sc_clone.getXmlCorrupt());
	}
}
