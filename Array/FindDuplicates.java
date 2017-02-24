import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
	
	// when at position i, flip the number at position nums[i] - 1 to negative
	// if it is already negative, it means nums[i] has already appeared
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) result.add(Math.abs(index + 1));
			nums[index] = -nums[index];
		}
		return result;
	}
	
//	public List<Integer> findDuplicates(int[] nums) {
//		List<Integer> result = new ArrayList<>();
//		for (int i = 0; i < nums.length; i++) {
//			while (nums[i] > 0 && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
//				swap(nums, i, nums[i] - 1);
//			}
//			if (nums[i] > 0 && nums[i] != i + 1) { 
//				result.add(nums[i]);
//				nums[i] = 0;
//			}
//		}
//		return result;
//	}
//	
//	private void swap(int[] nums, int i, int j) {
//		int temp = nums[i];
//		nums[i] = nums[j];
//		nums[j] = temp;
//	}

	public static void main(String[] args) {
		FindDuplicates fd = new FindDuplicates();
		int[] nums = {4,3,2,7,8,2,3,1};
		for (int n : fd.findDuplicates(nums)) {
			System.out.println(n);
		}
	}

}
