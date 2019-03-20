package businesscardocr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class NameParserTests {
	
	private String line;
	private String expectedName;
	private Parser nameParser;

	@Before
	public void setup() {
		nameParser = new NameParser();
	}
	
	@Test
	public void testProcessLine_returnsName() {
		expectedName = "Mike Hale";
		line = "Mike Hale";
		lineContainsName(line, expectedName);
	}
	@Test
	public void testProcessMoreComplexLine() {
		expectedName = "Betty Boop";
		line =  String.format("Software Engineer, Betty Boop, Foo Industries",
				expectedName);
		lineContainsName(line, expectedName);
	}
	
	@Test
	public void testLineWithoutName_returnsEmptyString() {
		expectedName = "";
		line =  String.format("Software Engineer, Foo Industries",
				expectedName);
		lineContainsName(line, expectedName);
	}

	public void lineContainsName(String line, String expectedName) {
		String actualName = nameParser.processLine(line);
		assertEquals(expectedName, actualName);
	}

}
