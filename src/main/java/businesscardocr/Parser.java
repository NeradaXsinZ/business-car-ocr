package businesscardocr;

public interface Parser {
	
	/**
	 * <p>Parses the line and returns the relevant item</p>
	 * @param line the line to be parsed
	 * @return A String containing the relevant match
	 */
	public String processLine(String line);
	
	/**
	 * Get the result {@link #processLine} 
	 * @return a string containing the parsed value
	 */
	public String getMatch();
}
