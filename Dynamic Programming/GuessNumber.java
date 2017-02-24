
public class GuessNumber {
	// Simpler version of Dungeon game
	public int getMoneyAmount(int n) {
		int[][] cache = new int[n + 1][n + 1];
		return dp(cache, 1, n);
	}
	
	private int dp(int[][] cache, int start, int end) {
		if (start >= end) return 0;
		if (cache[start][end] > 0) return cache[start][end];
		int res = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			int temp = i + Math.max(dp(cache, start, i - 1), dp(cache, i + 1, end));
			res = Math.min(res, temp);
		}
		cache[start][end] = res;
		return res;
	}
	
	public static void main(String[] args) {
		GuessNumber gn = new GuessNumber();
		System.out.println(gn.getMoneyAmount(2));
	}
}
