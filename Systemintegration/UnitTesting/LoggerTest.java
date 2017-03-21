package UnitTesting;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import App.AppException;
import App.Logger;
import App.Logger.severity;
import App.Severity;

public class LoggerTest {

	
	private Logger l = new Logger();
	
	@Test
	public void loggrTest() {
		//fail("Not yet implemented");

		Logger l = new Logger();
		l.append(Severity.FATAL, "ett message", AppException.ErrorCode.DOLIBARR_BULK_FAIL);


	}
}
