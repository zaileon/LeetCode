
public class PredictTheWinner {

	// you and your opponent are spliting the sum. Every time you pick a num, you gain num, while every time your opponent 
	// picks a num, you lose num. in the end, if you can break even (this problem includes equal), you win
	public boolean predictTheWinner(int[] nums) {
		return helper(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]) >= 0;
    }
	
	private int helper(int[] nums, int i, int j, Integer[][] memo) {
		if (memo[i][j] == null) {
			// you pick either nums[i], and gain nums[i], but lose helper(nums,i+1,j)
			// or pick nums[j], and gain nums[j], but lose helper(nums, i, j-1)
			memo[i][j] = i == j ? nums[i] : Math.max(nums[i] - helper(nums, i + 1, j, memo), nums[j] - helper(nums, i, j - 1, memo));
		}
		return memo[i][j];
	}
	
	public static void main(String[] args) {
		PredictTheWinner ptw = new PredictTheWinner();
//		int[] nums = {1,5,2}; // false
//		int[] nums = {0}; // true
		int[] nums = {1,1}; // true
//		int[] nums = {1,5,233,7}; // true
		System.out.println(ptw.predictTheWinner(nums));
	}
}
