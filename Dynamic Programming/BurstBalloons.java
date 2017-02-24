
public class BurstBalloons {
	public int maxCoins(int[] nums) {
		int[] coins = new int[nums.length + 2];
		int n = 1;
		for (int num : nums) if (num > 0) coins[n++] = num;
		coins[0] = coins[n++] = 1;
		int[][] cache = new int[n][n];
		return dp(cache, coins, 0, n - 1);
	}
	
	private int dp(int[][] cache, int[] coins, int left, int right) {
		if (left + 1 == right) return 0;
		if (cache[left][right] > 0) return cache[left][right];
		int sum = 0;
		for (int i = left + 1; i < right; i++) {
			sum = Math.max(sum, 
					coins[left] * coins[i] * coins[right] +
					dp(cache, coins, left, i) + 
					dp(cache, coins, i, right));
		}
		cache[left][right] = sum;
		return sum;
	}
	
	public static void main(String[] args) {
		BurstBalloons bb = new BurstBalloons();
		int[] nums = {3,1,5,8};
		System.out.println(bb.maxCoins(nums));
	}
}
