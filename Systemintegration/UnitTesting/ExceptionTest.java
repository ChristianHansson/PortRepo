package UnitTesting;
import org.junit.Test;

import App.AppException;
import App.Severity;

public class ExceptionTest {

	@Test (expected = AppException.class)
	public void test() throws AppException {
		MethodThatThrows();
	}
	
	/*
	 * Metod som kastar ett AppException.
	 * ExceptionTest klassen testar ifall den verkligen kastar ett undantag.
	 * */
	public void MethodThatThrows() throws AppException{		
		throw new AppException(Severity.FATAL,"FEL nånstans");
	}
}
