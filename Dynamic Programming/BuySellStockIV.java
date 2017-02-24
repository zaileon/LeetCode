import java.util.Arrays;

public class BuySellStockIV {
	public int maxProfit(int k, int[] prices) {
        int len = prices.length;
		if (k == 0 || len < 2) return 0;
		if (k > len / 2) return quickSolve(prices);
		
		int[] buy = new int[k+1];
		int[] sell = new int[k+1];
		Arrays.fill(buy, Integer.MIN_VALUE);
		for (int i = 0; i < len; i++) {
			for (int j = k; j > 0; j--) {
				sell[j] = Math.max(sell[j], buy[j] + prices[i]);
				buy[j]  = Math.max(buy[j], sell[j-1] - prices[i]);
			}
		}
		return sell[k];
	}
	
	private int quickSolve(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i-1]) profit += prices[i]-prices[i-1];
		}
		return profit;
	}
	
	// a slower solution
//	public int maxProfit(int k, int[] prices) {
//        int len = prices.length;
//		if (k == 0 || len < 2) return 0;
//		if (k > len / 2) return quickSolve(prices);
//		
//		int[][] dp = new int[k + 1][prices.length];
//		for (int i = 1; i <= k; i++) {
//			int tmpMax = -prices[0];
//			for (int j = 1; j < prices.length; j++) {
//				dp[i][j] = Math.max(dp[i][j-1], prices[j] + tmpMax);
//				// profit with at most i-1 transactions up until day j-1, then buy at j, and sell next day
//				tmpMax = Math.max(tmpMax, dp[i-1][j-1] - prices[j]); 
//			}
//		}
//		return dp[k][prices.length - 1];
//	}
}
