import java.util.Arrays;

public class DistinctSubsequence {
	public int numDistinct(String s, String t) {
		if (s == null || t == null) return 0;
		int m = t.length(), n = s.length();
		int[][] dp = new int[m + 1][n + 1];
		Arrays.fill(dp[0], 1);
		for (int i = 1; i <= m; i++) {
			for (int j = i; j <= n; j++) {
				if (s.charAt(j - 1) == t.charAt(i - 1)) 
					dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
				else 
					dp[i][j] = dp[i][j - 1];
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		DistinctSubsequence ds = new DistinctSubsequence();
//		String s = "eee", t = "eee";
//		String s = "", t = "a";
//		String s = "a", t = "";
		String s = "b", t = "a";
//		String s = "rabbbit", t = "rabbit";
		System.out.println(ds.numDistinct(s, t));
	}
}
