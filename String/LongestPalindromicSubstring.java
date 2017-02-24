
public class LongestPalindromicSubstring {
	
	int low, maxLen;
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 2) return s;
		for (int i = 0; i < s.length() - 1; i++) {
			expandPalindrome(s, i, i); // odd length
			// only need to check even length when s[i]=s[i+1]
			if (s.charAt(i) == s.charAt(i + 1)) expandPalindrome(s, i, i + 1);
		}
		return s.substring(low, low + maxLen);
	}
	
	private void expandPalindrome(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--; j++;
		}
		// shrink back i, j by 1
		if (j - i - 1 > maxLen) {
			low = i + 1;
			maxLen = j - i - 1;
		}
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		String s = "aaaaaa";
		System.out.println(lps.longestPalindrome(s));
	}

}
