
public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) return 0;
		int i = s.length() - 1;
		while (i >= 0) { 
			if (s.charAt(i) != ' ') break; 
			i--;
		}
		if (i < 0) return 0;
		int start = i;
		while (i >= 0) {
			if (s.charAt(i) == ' ') break;
			i--;
		}
		return start - i;
	}
	
	public static void main(String[] args) {
		LengthOfLastWord llw = new LengthOfLastWord();
		System.out.println(llw.lengthOfLastWord("   "));
		System.out.println(llw.lengthOfLastWord("Hello world"));
		System.out.println(llw.lengthOfLastWord(" "));
		System.out.println(llw.lengthOfLastWord("a "));
	}

}
