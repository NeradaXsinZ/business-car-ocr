package businesscardocr;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmailParserTests {
	
	private String line;
	private String expectedEmail;
	private Parser emailParser;

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
	@Test
	public void testProcessComplexLine() {
		expectedEmail = "my.email@example.com";
		line =  String.format("Hi, my name is example and my email address is"
				+ " %s. Please email me at your leisure.", expectedEmail);
		lineContainsEmailAddress(line, expectedEmail);
	}
	
	@Test 
	public void testEmailWithSymbols() {
		expectedEmail = "#*&(*&@example.com";
		line = String.format("Email:  %s",expectedEmail);
		lineContainsEmailAddress(line, expectedEmail);
	}
	@Test 
	public void testFailure_returnsEmptyString() {
		expectedEmail = "";
		line = "Email:  my.email.example.com@.com";
		lineContainsEmailAddress(line, expectedEmail);
	}
	
	@Test 
	public void testProcessLineFails_whenAtIsMissing() {
		expectedEmail = "";
		line = "Email:  my.email.example.com.com";
		lineContainsEmailAddress(line, expectedEmail);
	}
		
	private void lineContainsEmailAddress(String line, String expectedEmail) {
		String actualEmail = emailParser.processLine(line);
		assertEquals(expectedEmail, actualEmail);
	}

}
