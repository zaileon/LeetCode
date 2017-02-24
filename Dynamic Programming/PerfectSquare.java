import java.util.Arrays;

public class PerfectSquare {
	public int numSquares(int n) {
		int r = (int) Math.sqrt(n);
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= r; i++) {
			for (int j = i * i; j <= n; j++) {
				dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		PerfectSquare ps = new PerfectSquare();
		System.out.println(ps.numSquares(13));
	}

}
