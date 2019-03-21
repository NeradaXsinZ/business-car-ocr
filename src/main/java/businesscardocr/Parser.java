package businesscardocr;

public interface Parser {
	
	/**
	 * Parses the line and returns the relevant item
	 * @param line the line to be parsed
	 * @return A String containing the relevant match
	 */
	public String processLine(String line);
	
	/**
	 * Get the result of {@link #processLine} 
	 * @return a string containing the parsed value
	 */
	public String getValue();
}
