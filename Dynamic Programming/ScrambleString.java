
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		if (s1.equals(s2)) return true;
		int len = s1.length();
		
		// pruning
		int[] letters = new int[26];
		for (int i = 0; i < len; i++) {
			letters[s1.charAt(i) - 'a']++;
			letters[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (letters[i] != 0) return false;
		}
		
		// recursion
		for (int i = 1; i < s1.length(); i++) {
			if (isScramble(s1.substring(0, i),  s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
			if (isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i))) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		ScrambleString ss = new ScrambleString();
		String s1 = "great", s2 = "rgate";
		System.out.println(ss.isScramble(s1, s2));
	}
}
