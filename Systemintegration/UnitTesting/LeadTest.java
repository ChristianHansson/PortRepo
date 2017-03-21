package UnitTesting;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import App.Lead;

public class LeadTest {

	private Lead lead = new Lead("test@test.com", "name nameson", 
			"adress 23", "23223", "Ankeborg", "name namesson II", "12345678", "23", "Nån dålig");
	@Test
	public void test() {
		//fail("Not yet implemented");
		assertThat(lead.email, is("test@test.com"));
		assertThat(lead.name, is("name nameson"));
		assertThat(lead.adress, is("adress 23"));
		assertThat(lead.zip, is("23223"));
		assertThat(lead.city, is("Ankeborg"));
		assertThat(lead.contact, is("name namesson II"));
		assertThat(lead.tele, is("12345678"));
		assertThat(lead.size, is("23"));
		assertThat(lead.currentProvider, is("Nån dålig"));
	}

}
