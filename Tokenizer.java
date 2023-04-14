
public class Tokenizer {
	private static final String DELIMITER = "\"(?:\\\\\"|[^\"])*?\"|[\\s.,;:+*/|!=><@?#%&(){}\\-\\^\\[\\]\\&&]+";
	
	public static String[] tokenizer(String javaStmt) {
		String[] tokens = javaStmt.split(DELIMITER);
		return tokens;
	}
}
