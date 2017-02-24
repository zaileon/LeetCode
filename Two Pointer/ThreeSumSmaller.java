import java.util.Arrays;


public class ThreeSumSmaller {
	
	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > target / 3) break;
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] < target) {
					count += k - j;
					j++;
				} else {
					k--;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		ThreeSumSmaller tss = new ThreeSumSmaller();
		int[] nums = {-2, 0, 1, 3}; int target = 2;
		System.out.println(tss.threeSumSmaller(nums, target));
	}

}
