
public class DetectCapital {

	public boolean detectCapitalUse(String word) {
		if (word.length() == 1) return true;
		boolean capital = isCapital(word.charAt(1));
		if (!isCapital(word.charAt(0)) && capital) return false;
		for (int i = 2; i < word.length(); i++) {
			if (capital ^ isCapital(word.charAt(i))) return false;
		}
		return true;
	}
	
	private boolean isCapital(char c) {
		return c >= 'A' && c <= 'Z';
	}
	
	public static void main(String[] args) {
		DetectCapital dc = new DetectCapital();
		System.out.println(dc.detectCapitalUse("USA"));
		System.out.println(dc.detectCapitalUse("Flag"));
		System.out.println(dc.detectCapitalUse("FlaG"));
	}
}
