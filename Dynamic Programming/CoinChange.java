import java.util.Arrays;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i] - 1 > dp[i-coin]) dp[i] = dp[i-coin] + 1;
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
	
	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
//		int[] coins = {2}; int amount = 3;
		int[] coins = {1,2,5}; int amount = 11;
		System.out.println(cc.coinChange(coins, amount));
	}
}
