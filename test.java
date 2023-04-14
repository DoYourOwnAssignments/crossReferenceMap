
public class test {
	private static final String DELIMITER = "\"(?:\\\\\"|[^\"])*?\"|[\\s.,;:+*/|!=><@?#%&(){}\\-\\^\\[\\]\\&&]+";
	public static final String KEYWORD[] = { "abstract", "continue", "for", "new", "switch", "assert", "default",
			"goto", "package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double",
			"implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum",
			"instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final",
			"interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float",
			"native", "super", "while" };

	public static void main(String args[]) {

		String exp = "System.out.println(abstract long _a$);";
		// exception: invalid keyword ?*%$^ as identifier
		// replace curr line with space
		exp = exp.replaceAll(DELIMITER, " ");
		String[] word = exp.split(" ");
		Object list;
		list = replace(KEYWORD, word);
		System.out.println(list);
	}

	public static Object replace(String[] arr, String[] word) {
		LinkedList wordList = new LinkedList();
		// used to mark whether the keyword appears
		boolean marker = true;
		for (int i = 0; i < word.length; i++) {
			marker = true; // reset marker
			 for (int k = 0; k < arr.length; k++) {
				// when the keyword appears
				if (word[i].equals(arr[k])) {
					marker = false;
					// end inner loop
					break;
				}
			}
			// no keywords, add to the list
			if (marker == true) {
				wordList.addToTail(word[i]);
			}
		}
		return wordList;
	}
}
