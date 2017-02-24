
public class LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {
		int max = 0, start = 0;
		int[] cnts = new int[26];
		for (int end = 0; end < s.length(); end++) {
			max = Math.max(max, ++cnts[s.charAt(end) - 'A']);
			if (end - start + 1 > max + k) cnts[s.charAt(start++) - 'A']--;
		}
		return s.length() - start;
	}
	
	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement lrcr = new LongestRepeatingCharacterReplacement();
//		System.out.println(lrcr.characterReplacement("ABAB", 2)); // 4
		System.out.println(lrcr.characterReplacement("AAAA", 2)); // 4
		System.out.println(lrcr.characterReplacement("AABABBA", 1)); // 4
	}
}
