package businesscardocr;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.util.Span;
/**
 * 
 * @author rnettey
 *
 */
public class NameParser implements Parser{

	private TokenNameFinderModel model ;
	private NameFinderME nameFinder;
	private String name = "";
	
	public NameParser() {
		InputStream inputStream = getClass().getResourceAsStream("/en-ner-person.bin");
		try {
			model= new TokenNameFinderModel(inputStream);
			nameFinder = new NameFinderME(model);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public String processLine(String line) {
		if(name.isEmpty()) {
			//Adapted from: https://community.hortonworks.com/articles/76240/using-opennlp-for-identifying-names-from-text.html
			Tokenizer tokenizer = SimpleTokenizer.INSTANCE;
			String[] tokens = tokenizer.tokenize(line); 
			Arrays.asList(tokens).forEach(token -> System.out.println(token));
			Span[] nameSpans = nameFinder.find(tokens);
			String[] names= Span.spansToStrings(nameSpans, tokens); 
			name = (names != null && names.length > 0) ? names[0] : "";
		}
		return name;
	}
	
	@Override
	public String getMatch() {
		return null;
	}

}
