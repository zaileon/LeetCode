
public class PaintHouse {
	public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int[] dp = costs[0], temp = new int[3];
		for (int i = 1; i < costs.length; i++) {
			System.arraycopy(dp, 0, temp, 0, 3);
			dp[0] = Math.min(temp[1], temp[2]) + costs[i][0];
			dp[1] = Math.min(temp[0], temp[2]) + costs[i][1];
			dp[2] = Math.min(temp[0], temp[1]) + costs[i][2];
		}
		return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
