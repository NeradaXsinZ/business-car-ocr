package businesscardocr;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PhoneNumberParserTests {

	private String line;
	private String expectedPhoneNumber;
	private Parser phoneNumberParser;

	@Before
	public void setup() {
		 phoneNumberParser = new PhoneNumberParser();
	}

	@Test
	public void testProcessLine_returnsPhoneNumber() {
		expectedPhoneNumber = "7177249371";
		line = "7177249371";
		lineContainsPhoneNumber(line, expectedPhoneNumber);
	}

	@Test
	public void testLineWithFormatting() {
		expectedPhoneNumber = "7177249371";
		line = String.format("(717) 724-9371");
		lineContainsPhoneNumber(line, expectedPhoneNumber);
	}
	
	@Test
	public void testLineWithLabel() {
		expectedPhoneNumber = "7177249371";
		line = "Phone: (717) 724-9371";
		lineContainsPhoneNumber(line, expectedPhoneNumber);
	}
	
	@Test
	public void testLineWithFaxNumber_returnsEmptyString() {
		expectedPhoneNumber = "";
		line = "Fax: (717) 633-8845";
		lineContainsPhoneNumber(line, expectedPhoneNumber);
	}
	
	@Test
	public void testLineWithPhoneAndFaxNumber() {
		expectedPhoneNumber = "7177249371";
		line = String.format("Phone: (717) 724-9371 %nFax: (717) 633-8845");
		lineContainsPhoneNumber(line, expectedPhoneNumber);
	}
	
	@Test
	public void testLineWithPhoneAndFaxNumberReversed() {
		expectedPhoneNumber = "7177249371";
		line = String.format("Fax: (717) 633-8845 %nTel: (717) 724-9371");
		lineContainsPhoneNumber(line, expectedPhoneNumber);
	}
	
	
	@Test
	public void testLineWithLabelSuffix() {
		expectedPhoneNumber = "7177249371";
		line = String.format("(717) 724-9371 Tel%n(717) 633-8845 Fax");
		lineContainsPhoneNumber(line, expectedPhoneNumber);
	}
	
	
	
	@Test
	public void testLineWithCountryPrefix() {
		expectedPhoneNumber = "17177249371";
		line = "Phone: +1 (717) 724-9371";
		lineContainsPhoneNumber(line, expectedPhoneNumber);
	}

	public void lineContainsPhoneNumber(String line, String expectedName) {
		String actualName = phoneNumberParser.processLine(line);
		assertEquals(expectedName, actualName);
	}
}
