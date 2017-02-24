
public class OnesAndZeroes {

	// Two-dimensional knapsack problem
	// for each string, we either form it or skip it
	public int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m+1][n+1];
		for (String str : strs) {
			int ones = 0, zeros = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '1') ones++; else zeros++;
			}
			for (int i = m; i >= zeros; i--) {
				for (int j = n; j >= ones; j--) {
					dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
				}
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		OnesAndZeroes oz = new OnesAndZeroes();
		String[] strs = {"10", "0001", "111001", "1", "0"}; int m = 5, n = 3;
		System.out.println(oz.findMaxForm(strs, m, n));
	}
}
