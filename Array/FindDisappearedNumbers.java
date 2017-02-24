import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0) nums[index] = -nums[index];
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) result.add(i + 1);
		}
		return result;
	}
	
//	public List<Integer> findDisappearedNumbers(int[] nums) {
//		List<Integer> result = new ArrayList<>();
//		for (int i = 0; i < nums.length; i++) {
//			while (nums[i] > 0 && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i])
//				swap(nums, i, nums[i] - 1);
//		}
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] != i + 1) result.add(i + 1);
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
		FindDisappearedNumbers fdn = new FindDisappearedNumbers();
		int[] nums = {4,3,2,7,8,2,3,1};
		for (int n : fdn.findDisappearedNumbers(nums)) {
			System.out.println(n);
		}
	}

}
