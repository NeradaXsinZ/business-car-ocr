package businesscardocr;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.junit.Test;

public class BusinessCardParserTests {

	private BusinessCardParser cardParser;
	private InputStream file;

	@Test
	public void testBusinessCards_areParsedCorrectly() {
		testBusinessCard("/AnitaRodrigues.txt", "Anita Rodrigues", "17051151209", "arodrigues@mail.mil");	
		testBusinessCard("/LisaHaung.txt", "Lisa Haung", "4105551234", "lisa.haung@foobartech.com");	
		testBusinessCard("/MikeSmith.txt", "Mike Smith", "4105551234", "msmith@asymmetrik.com");	
		testBusinessCard("/ArthurWilson.txt", "Arthur Wilson", "17035551259", "awilson@abctech.com");	

	}
	
	@Test
	public void testCardWithNoName() {
		testBusinessCard("/NoName.txt", "", "17051151209", "mhale@mail.mil");	
	}
	@Test
	public void testCardWithNoPhoneNumber() {
		testBusinessCard("/NoPhoneNumber.txt", "Kelly Smith", "", "ksmithy@gmail.com");	

	}
	@Test
	public void testCardWithNoEmailAddress() {
		testBusinessCard("/NoEmailAddress.txt", "David Kim", "17051151125", "");	
	}

	
	public void testBusinessCard(String filePath, String expectedName, String expectedPhoneNumber, String expectedEmailAddress) {
		 String document = BusinessCardParser.getFileContent(getClass().getResource(filePath).getFile());
		 ContactInfo actualInfo =  BusinessCardParser.getContactInfo(document);
		 ContactInfo expectedInfo = new ContactInfo(expectedName, expectedPhoneNumber, expectedEmailAddress);
		 
		 assertEquals(expectedInfo.getName(), actualInfo.getName());
		 assertEquals(expectedInfo.getPhoneNumber(), actualInfo.getPhoneNumber());
		 assertEquals(expectedInfo.getEmailAddress(), actualInfo.getEmailAddress());
		 assertEquals(expectedInfo.toString(), actualInfo.toString());
		 
	} 
	
}
