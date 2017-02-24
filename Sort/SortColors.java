
public class SortColors {
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public void sortColors(int[] nums) {
		int zero = 0, second = nums.length - 1;
		for (int i = 0; i <= second; i++) {
			while (nums[i] == 2 && i < second) swap(nums, i, second--);
			while (nums[i] == 0 && i > zero) swap(nums, i, zero++); 
		}
	}
	
	public static void main(String[] args) {
		SortColors sc = new SortColors();
//		int[] nums = {0};
//		int[] nums = {2,1};
//		int[] nums = {0, 1};
		int[] nums = {1,2,0,1,1,2,0,0};
		sc.sortColors(nums);
		for (int num : nums) {
			System.out.println(num);
		}
	}
}
