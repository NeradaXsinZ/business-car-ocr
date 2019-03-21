package businesscardocr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author rnettey
 *
 */
public class EmailParser implements Parser{
	/*
	 * ASSUMPTIONS:
	 * 		-The email address on the card is a valid address
	 * 		-There is a whitespace character preceding the email address
	 * 		-The email address contains no whitespace
	 * 		-The email address ends in an alpha-numeric character
	 * 		-There is at lease one non-whitespace character before the TLD
	 */
	private final Pattern EMAIL_PATTERN = Pattern.compile("\\S+@\\S+\\.\\S[a-zA-Z1-9]+");
	private String emailAddress = "";
	
	@Override
	public String processLine(String line) {
		if(emailAddress.isEmpty()) { 
			Matcher emailMatcher = EMAIL_PATTERN.matcher(line);
			if(emailMatcher.find()) {
				emailAddress = emailMatcher.group(); //set email to first match
			}	
		}
		return emailAddress;
		
	}
	
	@Override
	public String getValue() {
		return emailAddress;
	}

}
