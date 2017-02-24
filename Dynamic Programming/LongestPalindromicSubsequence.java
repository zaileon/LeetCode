
public class LongestPalindromicSubsequence {
	
	public int longestPalindromeSubseq(String s) {
		int[][] dp = new int[s.length()][s.length()];

		for (int i = s.length() - 1; i < s.length(); i++) {
			dp[i][i] = 1;
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) 
					dp[i][j] = dp[i+1][j-1] + 2;
				else 
					dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
			}
		}
		return dp[0][s.length() - 1];
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		System.out.println(lps.longestPalindromeSubseq("bbbab")); // 4
		System.out.println(lps.longestPalindromeSubseq("cbbd")); // 2
	}
}
