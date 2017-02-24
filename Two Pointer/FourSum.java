import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		int len = nums.length;
		if (nums == null || len < 4) return result;
		
		Arrays.sort(nums);
		int max = nums[len - 1];
		if (target < 4 * nums[0] || target > 4 * max) return result;
		
		for (int i = 0; i < nums.length - 3; i++) {
			int z = nums[i];
			if (i > 0 && nums[i - 1] == z) continue; // avoid duplicate
			if (z + 3 * max < target) continue; // z too small
			if (4 * z > target) break; // z is too larget
			if (4 * z == target) { // continuous z
				if (nums[i + 3] == z) result.add(Arrays.asList(z, z, z, z));
				break;
			}
			threeSum(result, nums, i + 1, target - z, z);
			while (i < nums.length - 3 && nums[i+1] == nums[i]) i++;
		}
		return result;
	}
	
	public void threeSum(List<List<Integer>> result, int[] nums, int start, int target, int previous) {
		int max = nums[nums.length - 1];
		if (3 * nums[start] > target || 3 * max < target) return;
		for (int i = start; i < nums.length - 2; i++) {
			int z = nums[i];
			if (i > start && nums[i - 1] == z) continue;
			if (z + 2 * max < target) continue;
			if (3 * z > target) break;
			if (3 * z == target) {
				if (nums[i + 2] == z) result.add(Arrays.asList(previous, z, z, z));
				break;
			}
			twoSum(result, nums, i + 1, target - z, previous, z);
		}
	}
	
	private void twoSum(List<List<Integer>> result, int[] nums, int start, int target, int first, int second) {
		int max = nums[nums.length - 1];
		if (2 * nums[start] > target || 2 * max < target) return;
		int i = start, j = nums.length - 1;
		while (i < j) {
			int sum = nums[i] + nums[j];
			if (sum == target) {
				result.add(Arrays.asList(first, second, nums[i], nums[j]));
				while (i < j && nums[i] == nums[i + 1]) i++;
				while (i < j && nums[j] == nums[j - 1]) j--;
				i++; j--;
			} else if (sum < target) {
				while (i < j && nums[i] == nums[i + 1]) i++;
				i++;
			} else {
				while (i < j && nums[j] == nums[j - 1]) j--;
				j--;
			}
		}
	}
	
	public static void main(String[] args) {
		FourSum fs = new FourSum();
//		int[] nums = {-3,-2,-1,0,0,1,2,3}; int target = 0;
//		int[] nums = {0,0,0,0}; int target = 0;
		int[] nums = {1,0,-1,0,-2,2}; int target = 0;
		for (List<Integer> list : fs.fourSum(nums, target)) {
			for (int i : list) {
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
