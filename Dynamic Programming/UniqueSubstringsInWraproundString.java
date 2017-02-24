public class UniqueSubstringsInWraproundString {

	// calculate max # of substrings ending with current character
	// if not greater than the count[index], it means the substrings are already included in previous counting
	// this is not very dp...
	public int findSubstringInWraproundString(String p) {
		int[] count = new int[26];
		int maxLen = 0;
		for (int i = 0; i < p.length(); i++) {
			if (i > 0 && (p.charAt(i - 1) + 1 == p.charAt(i) || p.charAt(i - 1) - 25 == p.charAt(i)))
				maxLen++;
			else
				maxLen = 1;
			int index = p.charAt(i) - 'a';
			count[index] = Math.max(count[index], maxLen);
		}
		int sum = 0;
		for (int i = 0; i < 26; i++) {
			sum += count[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		UniqueSubstringsInWraproundString usws = new UniqueSubstringsInWraproundString();
		// for the first 'd', there are four substrings ending with d, i.e. "abcd", "bcd", "cd", "d"
		// for the second 'd', all the three substrings ending with it already appeared
		System.out.println(usws.findSubstringInWraproundString("abcdbcd"));
		System.out.println(usws.findSubstringInWraproundString(""));
		System.out.println(usws.findSubstringInWraproundString("a"));
		System.out.println(usws.findSubstringInWraproundString("cac"));
		System.out.println(usws.findSubstringInWraproundString("zab"));
	}
}
