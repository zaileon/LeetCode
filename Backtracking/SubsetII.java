import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
	
	// Assume Ai appear ki times, the total size would be (k0+1)*(k1+1)*...
//	public List<List<Integer>> subsetsWithDup(int[] nums) {
//		List<List<Integer>> result = new ArrayList<>();
//		List<Integer> empty = new ArrayList<>();
//		result.add(empty);
//		Arrays.sort(nums);
//		for (int i = 0; i < nums.length; i++) {
//			int count = 1;
//			while (i + count < nums.length && nums[i + count] == nums[i]) 
//				count++;
//			int previousSize = result.size(); // backup the size, otherwise result's size keep increasing
//			for (int j = 0; j < previousSize; j++) {
//				List<Integer> copy = new ArrayList<>(result.get(j));
//				for (int k = 0; k < count; k++) {
//					copy.add(nums[i]);
//					result.add(new ArrayList<>(copy));
//				}
//			}
//			i += count - 1;
//		}
//		return result;
//	}
	
//	public List<List<Integer>> subsetsWithDup(int[] nums) {
//		List<List<Integer>> result = new ArrayList<>();
//		result.add(new ArrayList<>());
//		Arrays.sort(nums);
//		int sz = 0, startIndex;
//		for (int i = 0; i < nums.length; i++) {
//			// when nums[i] is not equal to nums[i-1], attach the new number to every exsiting list
//			// else only attach the duplicated number to the last added lists (prev size - size)
//			startIndex = i > 0 && nums[i] == nums[i - 1] ? sz : 0;
//			sz = result.size();
//			for (int j = startIndex; j < sz; j++) {
//				List<Integer> temp = new ArrayList<>(result.get(j));
//				temp.add(nums[i]);
//				result.add(temp);
//			}
//		}
//		return result;
//	}
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(result, new ArrayList<Integer>(), nums, 0);
		return result;
	}
	
	private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
		result.add(new ArrayList<Integer>(list));
		for (int i = start; i < nums.length; i++) {
			if (i == start || nums[i] != nums[i - 1]) {
				list.add(nums[i]);
				backtrack(result, list, nums, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}
	
	
	public static void main(String[] args) {
		SubsetII subset = new SubsetII();
//		int[] nums = {1,2,2};
		int[] nums = {2,2,3,3,3};
		for (List<Integer> set : subset.subsetsWithDup(nums)) {
			for (int i : set) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}
}
