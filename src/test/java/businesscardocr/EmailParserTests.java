package businesscardocr;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmailParserTests {
	
	String line;
	String expectedEmail;
	EmailParser emailParser;

	@Before
	public void setup() {
		 emailParser = new EmailParser();
	}
	
	@Test
	public void testProcessLine_returnsEmailAddress() {
		 expectedEmail = "my.email@example.com";
		 line = "my.email@example.com";
		 lineContainsEmailAddress(line, expectedEmail);
	}
	
	public void lineContainsEmailAddress(String line, String expectedEmail) {
		String actualEmail = emailParser.processLine(line);
		assertEquals(expectedEmail, actualEmail);
	}

}
