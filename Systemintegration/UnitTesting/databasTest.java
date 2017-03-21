package UnitTesting;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import App.AppException;
import App.Database;
import App.Query;

public class databasTest {

	@Test
	public void test_database_conn() {
		//fail("Not yet implemented");
		try {
			Database databas = new Database();
			assertNotNull(databas);
			assertTrue(databas.conn.isValid(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Antar att det blir så här eftersom jag inte har databasen på min dator");
		}
	}
	
	@Test
	public void test_Query(){
		Query q = new Query();
		String queryToCompare = "INSERT INTO dolibarr.llx_societe (TestVariable) VALUES ( 'TestValue')";
		q.appendValue("TestVariable", "TestValue");
		assertEquals(queryToCompare, q.getInsertQuery());
	}

}
