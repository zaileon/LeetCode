import java.util.Arrays;

public class MinSubArrayLen {
	
	// O(n) Two pointers
//	public int minSubArrayLen(int s, int[] nums) {
//		int len = Integer.MAX_VALUE;
//		for (int i = 0, j = 0, sum = 0; j < nums.length; j++) {
//			sum += nums[j];
//			if (sum >= s) {
//				while (sum >= s) {
//					sum -= nums[i++];
//				}
//				len = Math.min(len, j - i + 2);
//			}
//		}
//		return len == Integer.MAX_VALUE ? 0 : len;
//	}
	
	// O(nlgn) binary search
	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0) return 0;
		if (nums[0] >= s) return 1;
		int[] sums = new int[nums.length];
		sums[0] = nums[0];
		int len = Integer.MAX_VALUE;
		for (int i = 1, j = -1; i < nums.length; i++) {
			sums[i] = sums[i - 1] + nums[i];
			if (sums[i] > s) {
				j = Arrays.binarySearch(sums, j + 1, i, sums[i] - s);
				len = Math.min(len, i - j); 
			}
		}
		return len == Integer.MAX_VALUE ? 0 : len;
	}
	
	public static void main(String[] args) {
		MinSubArrayLen msal = new MinSubArrayLen();
		int[] nums = { 8 }; int s = 7;
//		int[] nums = { 2,3,1,2,4,3 }; int s = 7;
		System.out.println(msal.minSubArrayLen(s, nums));
	}
}
