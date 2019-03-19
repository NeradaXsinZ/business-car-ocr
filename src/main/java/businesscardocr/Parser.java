package businesscardocr;

public interface Parser {
	public String processLine(String line);
	public String getMatch();
}
