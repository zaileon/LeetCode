
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		
		dp[0][0] = true;
		
		// for empty string s, return true iff p is like "a*b*"
		for (int j = 1; j < n; j+= 2) {
			dp[0][j + 1] = p.charAt(j) == '*' && dp[0][j - 1];
		}
		
		// dp[i+1][j+1] return true for s[0...i] and p[0...j]
		// when p[j] != '*', return dp[i][j] && (p[j] == s[i] || p[j] == '.')
		// when p[j] == '*', two cases:
		//		1. p[j-1] repeat 0 time, dp[i+1][j-1]
		//      2. p[j-1] repeat at least 1 time
		//           if (s[i] == x) we compare s[0...i-1] and p[0...j], i.e. dp[i][j+1]
		// '.' match any character, not important in this problem
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (p.charAt(j) != '*') {
					dp[i + 1][j + 1] = dp[i][j] && isCharacterMatch(s.charAt(i), p.charAt(j));
				} else {
					dp[i + 1][j + 1] = dp[i + 1][j - 1] || (dp[i][j + 1] && isCharacterMatch(s.charAt(i), p.charAt(j - 1)));
				}
			}
		}
		return dp[m][n];
	}
	
	private boolean isCharacterMatch(char s, char p) {
		return '.' == p || s == p;
	}
	
	public static void main(String[] args) {
		RegularExpressionMatching rem = new RegularExpressionMatching();
		String s = "", p = "c*a*b";
//		String s = "", p = "c*a*";
//		String s = "aab", p = "c*a*b";
		System.out.println(rem.isMatch(s, p));
	}
}
