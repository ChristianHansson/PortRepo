package UnitTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Christian Hansson
 * @category test Suite
 * */

/**
 * DatabasTest also tests Query class
 * */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	ExceptionTest.class,
	LeadsTest.class,
	LeadTest.class,
	LoggerTest.class,
	PropertiesTest.class,
	ServerConnectionTest.class,
	databasTest.class,
	getLeads.class,
	LeadsDubletterTest.class,
	IntegritetTest.class,
	LeadsDubletterTest.class
})
public class MainTestClass {	
	public static void Main(String [] args){
		System.out.println("TestSuite körs nu");
	}
}
