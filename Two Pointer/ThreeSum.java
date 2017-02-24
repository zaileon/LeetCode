import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0) break;
			if (i > 0 && nums[i] == nums[i-1]) continue;
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum > 0) {
					while (j < k && nums[k-1] == nums[k]) k--;
					k--;
				} else if (sum < 0) {
					while (j < k && nums[j+1] == nums[j]) j++;
					j++;
				} else {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					while (j < k && nums[j+1] == nums[j]) j++;
					while (j < k && nums[k-1] == nums[k]) k--;
					j++; k--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		for (List<Integer> list : threeSum.threeSum(nums)) {
			for (int i : list) {
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

}
