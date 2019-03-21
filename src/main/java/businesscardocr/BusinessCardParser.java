package businesscardocr;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Solution for the Business Card OCR Challenge proposed by Asymmetrik
 * @see <a href="https://asymmetrik.com/programming-challenges/">Asymmetrik Challenges</a>
 * @author rnettey
 *
 */
public class BusinessCardParser {

	/**
	 * Get the contact info of a person using values parsed from
	 * a document
	 * @param document the document to parse
	 * @return The name, phone number, and email address on the
	 * businesscard 
	 */
	public static ContactInfo getContactInfo(String document) {
		Parser nameParser = new NameParser();
		Parser emailParser = new EmailParser();
		Parser phoneNumberParser = new PhoneNumberParser();
	
		emailParser.processLine(document);
		nameParser.processLine(document);
		phoneNumberParser.processLine(document);

		return new ContactInfo(nameParser.getValue(),
				phoneNumberParser.getValue(),
				emailParser.getValue());
		
	}
	
	/**
	 * Get the content of the file at the file path passed in.
	 * @param filePath path of the file for which to retrieve content
	 * @return The content of the file as a string 
	 */
	public static String getFileContent(String filePath) {
		String document = "";
		try(InputStream fileStream = new FileInputStream(filePath)){
			Scanner docReader = new Scanner(fileStream, "UTF-8");
			
			while(docReader.hasNextLine()) {
				document += docReader.nextLine() + " | ";
			}
		}
		catch(IndexOutOfBoundsException | IOException e) {
			String errMessage = "Either the system cannot find the file specified or no file was specified.";
			System.out.println(errMessage);
		}
		
		return document;
	}
	
	public static void main(String [] args) throws Exception {
		String document = getFileContent(args[0]);
        System.out.println(BusinessCardParser.getContactInfo(document));
	}

}
