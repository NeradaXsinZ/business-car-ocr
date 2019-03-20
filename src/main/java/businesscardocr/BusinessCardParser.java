package businesscardocr;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Solution for the Business Card OCR Challenge proposed by Asymmetrik
 * See {@link <href a=>}
 * @see <a href="https://asymmetrik.com/programming-challenges/">Asymmetrik Challenges</a>
 * @author rnettey
 *
 */
public class BusinessCardParser {

	
	public static ContactInfo getContactInfo(String document) {
		Parser nameParser = new NameParser();
		Parser emailParser = new EmailParser();
		Parser phoneNumberParser = new PhoneNumberParser();
	
		emailParser.processLine(document);
		nameParser.processLine(document);
		phoneNumberParser.processLine(document);

		return new ContactInfo(nameParser.getMatch(),
				emailParser.getMatch(),
				phoneNumberParser.getMatch());
		
	}
	
	public static void main(String [] args) {
		String document = "";
		
		try(InputStream fileStream = new FileInputStream(args[0])){
			Scanner docReader = new Scanner(fileStream);
			
			while(docReader.hasNextLine()) {
				document += docReader.nextLine() + " | ";
			}
            System.out.println(BusinessCardParser.getContactInfo(document));
		}
		catch(IOException e) {
			String errMessage = String.format("Either the system cannot find the file specified or no file was specified%n%s", e.toString());
			System.out.println();
		}
	}

}
