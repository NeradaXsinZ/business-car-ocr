package businesscardocr;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	BusinessCardParserTests.class,
	NameParserTests.class,
	PhoneNumberParserTests.class,
	EmailParserTests.class
})
public class AllTests {

}
