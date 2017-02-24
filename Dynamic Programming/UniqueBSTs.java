
public class UniqueBSTs {
	
	public int numTrees(int n) {
		if (n < 1) return 0;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += dp[j-1] * dp[i-j];
            }
            dp[i] = sum;
        }
        return dp[n];
	}

	public static void main(String[] args) {
		UniqueBSTs ubst = new UniqueBSTs();
		System.out.println(ubst.numTrees(4));
	}

}
