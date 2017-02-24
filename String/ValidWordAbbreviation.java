
public class ValidWordAbbreviation {

	public boolean validWordAbbreviation(String word, String abbr) {
		int n = 0, j = 0;
		for (int i = 0; i < abbr.length(); i++) {
			if (Character.isDigit(abbr.charAt(i))) {
				if (n == 0 && abbr.charAt(i) == '0') return false;
				n = n * 10 + abbr.charAt(i) - '0';
			} else {
				j += n;
				if (j >= word.length() || word.charAt(j) != abbr.charAt(i)) return false;
				j++;
				n = 0;
			}
		}
		return j + n == word.length();
	}
	
	public static void main(String[] args) {
		ValidWordAbbreviation vwa = new ValidWordAbbreviation();
		String word = "a", abbr = "01";
//		String word = "hi", abbr = "2i";
//		String word = "internationalization", abbr = "i12iz5";
//		String word = "apple", abbr = "a2e";
		System.out.println(vwa.validWordAbbreviation(word, abbr));
	}
}
