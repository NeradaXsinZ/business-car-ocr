package businesscardocr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailParser implements Parser{
	private final Pattern EMAIL_PATTERN = Pattern.compile("\\S+@\\S+\\.\\S[a-zA-Z1-9]+");
	private String emailAddress;
	
	@Override
	public String processLine(String line) {
		if(emailAddress == null) {
			Matcher emailMatcher = EMAIL_PATTERN.matcher(line);
			if(emailMatcher.find()) {
				emailAddress = emailMatcher.group(); //set email to first match
			}	
		}
		return emailAddress;
		
	}
	
	@Override
	public String getMatch() {
		return emailAddress;
	}

}
