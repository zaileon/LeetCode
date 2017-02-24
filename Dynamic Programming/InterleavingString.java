
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		int m = s1.length(), n = s2.length();
		if (m < n) return isInterleave(s2, s1, s3);
		if (m + n != s3.length()) return false;
		
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
		}
		
		for (int i = 1; i <= m; i++) {
			dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
			for (int j = 1; j <= n; j++) {
				dp[j] = (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) ||
						(dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		InterleavingString is = new InterleavingString();
		String s1 = "aabcc", s2 = "dbbca";
//		String s3 = "aadbbbaccc";
		String s3 = "aadbbcbcac";
		System.out.println(is.isInterleave(s1, s2, s3));
	}
}
