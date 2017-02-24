import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisableSet {
	
	// sort the array first. 
	// If new element is divisible by the largest number in the set, add it to the set
	public List<Integer> largestDivisibleSubset(int[] nums) {
		if (nums == null || nums.length == 0) return new ArrayList<>();
		Arrays.sort(nums);
		int n = nums.length, maxLen = 0, index = -1;
		int[] count = new int[n], pre = new int[n];
		Arrays.fill(count, 1);
		// add smaller element at the head. It keeps the order of numbers
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (nums[j] % nums[i] == 0) {
					if (count[i] < count[j] + 1) {
						count[i] = count[j] + 1;
						pre[i]  = j;
					}
				}
			}
			if (count[i] > maxLen) {
				maxLen = count[i];
				index = i;
			}
		}
		ArrayList<Integer> result = new ArrayList<>(maxLen);
		for (int i = 0; i < maxLen; i++) {
			result.add(nums[index]);
			index = pre[index];
		}
		return result;
	}
	
	public static void main(String[] args) {
		LargestDivisableSet lds = new LargestDivisableSet();
//		int[] nums = {2,3};
		int[] nums = {1,2,4,8};
		for (int num : lds.largestDivisibleSubset(nums)) {
			System.out.println(num);
		}
	}
}
