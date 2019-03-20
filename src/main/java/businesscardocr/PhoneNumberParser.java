package businesscardocr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author rnettey
 *
 */
public class PhoneNumberParser implements Parser {

	/*
	 * ASSUMPTIONS:
	 * 		-There is only one phone number (the other is a fax number)
	 * 		-Phone numbers have at least 7 digits
	 */
	private final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\d{3}.?\\d{4}");
	private final Pattern NOT_CONTAINS_FAX_PATTERN = Pattern.compile("^((?!F).)*$");
	private final Pattern NUMERICAL_PATTERN = Pattern.compile("\\d+");
	private String phoneNumber = "";
	
	
	@Override
	public String processLine(String line) {
		String phoneNumberStr = getLineWithPhoneNumber(line);

		if(!phoneNumberStr.isEmpty()) {
			Matcher phoneNumberMatcher = NUMERICAL_PATTERN.matcher(phoneNumberStr);
			while(phoneNumberMatcher.find()) {
				phoneNumber += phoneNumberMatcher.group();
			}
		}
		return phoneNumber;
	}
	

	/**
	 * Gets the string containing the phone number
	 * @param line the line to check over
	 * @return A String  containing the phone number
	 */
	private String getLineWithPhoneNumber(String line) {
		String seperator = System.lineSeparator();
		List<String> lines = new ArrayList<>(Arrays.asList(line.split("\\||"+seperator)));
		lines.removeIf(PHONE_NUMBER_PATTERN.asPredicate().negate());
		lines.removeIf(NOT_CONTAINS_FAX_PATTERN.asPredicate().negate());
		return lines.get(0);
	}
	
	@Override
	public String getMatch() {
		return phoneNumber;
	}

}
