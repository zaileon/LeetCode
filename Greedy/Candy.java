import java.util.Arrays;

public class Candy {

	public int candy(int[] ratings) {
		int len = ratings.length;
		int[] nums = new int[len];
		Arrays.fill(nums, 1);
		for (int i = 1; i < len; i++) {
			if (ratings[i] > ratings[i - 1]) 
				nums[i] = nums[i - 1] + 1;
		}
		for (int i = len - 1; i > 0; i--) {
			if (ratings[i - 1] > ratings[i]) 
				nums[i - 1] = Math.max(nums[i] + 1, nums[i - 1]);
		}
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Candy c = new Candy();
		int[] ratings = {2,2};
		System.out.println(c.candy(ratings));
	}
}
