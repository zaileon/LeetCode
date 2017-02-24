
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int j = 0; j < n; j++) {
			if (p.charAt(j) == '*') dp[0][j + 1] = true;
			else break;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (s.charAt(i) == p.charAt(j) || '?' == p.charAt(j))
					dp[i + 1][j + 1] = dp[i][j];
				else if (p.charAt(j) == '*')
					// s[0...i]  and p[0...j]   when p[j] = '*', two cases:
					// 1. dp[i+1][j]   means s[0...i]  match p[0...j-1], * represents 0 char
					// 2. dp[i][j+1]   means s[0...j-1] match p[0...j], since '*' is the last char in p, we can add one or more chars at the end of s[0...j-1]
					//    and still get a match
					dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
			}
		}
		return dp[m][n];
	}
	
	
	// a slightly optimized solution, actually runs a little slower
//	public boolean isMatch(String s, String p) {
//		char[] str = s.toCharArray();
//		char[] pattern = p.toCharArray();
//		
//		// merge multiple consecutive *
//		// e.g. a**b***c -> a*b*c
//		int writeIndex = 0;
//		boolean isFirst = true;
//		for (int i = 0; i < p.length(); i++) {
//			if (pattern[i] == '*') {
//				if (isFirst) {
//					pattern[writeIndex++] = pattern[i];
//					isFirst = false;
//				}
//			} else {
//				pattern[writeIndex++] = pattern[i];
//				isFirst = true;
//			}
//		}
//		
//		boolean[][] dp = new boolean[str.length + 1][writeIndex + 1];
//		dp[0][0] = true;
//		// since we've merged *, only dp[0][1] can be true
//		if (writeIndex > 0 && pattern[0] == '*') dp[0][1] = true; 
//		
//		for (int i = 0; i < str.length; i++) {
//			for (int j = 0; j < writeIndex; j++) {
//				if (str[i] == pattern[j] || '?' == pattern[j])
//					dp[i+1][j+1] = dp[i][j];
//				else if (pattern[j] == '*')
//					dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j]; 
//			}
//		}
//		return dp[str.length][writeIndex];
//	}
	
	public static void main(String[] args) {
		WildcardMatching wm = new WildcardMatching();
		String s = "", p = "";
//		String s = "xaylmz", p = "x?y*z";
//		String s = "aab", p = "a?b";
		System.out.println(wm.isMatch(s, p));
	}
}
