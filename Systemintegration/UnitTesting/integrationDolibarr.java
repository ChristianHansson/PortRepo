package UnitTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import App.Database;
import App.ErrorHandling;
import App.Lead;
import App.Leads;
import App.Query;

public class integrationDolibarr {

	/**
	 * Detta testet är ett intgrations test för att testa integrationen mellan
	 * systemet och dolibarr. Det finns ett dokument som beskriver detta.
	 * */
	private Database database;
	private ErrorHandling errhan;
	private ServerConnectionCloneClass scClone;
	private Document doc;

	@Before
	public void addDatabasConnection(){
		database = new Database();
		errhan = new ErrorHandling();
		scClone = new ServerConnectionCloneClass();
	}
	@Test
	public void testSteg1Och2() {
		/*doc = scClone.getXmlWithoutError();
		assertNotNull(doc);
		errhan.addLeadsList(doc);
		errhan.checkCustomerDuplicates();
		errhan.deleteLeadsDolibarr();
		assertNotNull(errhan.countLeads());
		errhan.addLeadsDolibarr();
		System.out.println("Nu skall det finnas leads i databasen.");*/
	}
	/*@Test
	public void testSteg3Och4(){
		errhan.deleteLeadsDolibarr();
		System.out.println("Nu skall tabellen vara tom i databasen.");
	}*/
	/*@Test
	public void testSteg5And6And7And8(){
		doc = scClone.getXmlWithoutError();
		assertNotNull(doc);
		errhan.addLeadsList(doc);
		assertNotNull(errhan.countLeads());
		errhan.checkCustomerDuplicates();
		errhan.addLeadsDolibarr();
		
		System.out.println("Nu skall det ligga leads i databasen, steg 5.");
		System.out.println("Nu skall det köras igen.");
		System.out.println("Systemets process för att kontrollera dubletter är att rensa tabellen före.");
		
		errhan.deleteLeadsDolibarr();		
		errhan.checkCustomerDuplicates();
		errhan.addLeadsDolibarr();
		System.out.println("Nu har metoden för att lägga till leads i dolibarr körts igen.");
	}*/

}
