import java.util.Arrays;

public class ProductExceptSelf {
	
	public int[] productExceptSelf(int[] nums) {
		int[] products = new int[nums.length];
		Arrays.fill(products, 1);
		int left = 1;
		for (int i = 1; i < nums.length; i++) {
			left *= nums[i - 1];
			products[i] *= left;
		}
		int right = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			right *= nums[i + 1];
			products[i] *= right;
		}
		return products;
	}
	
	public static void main(String[] args) {
		ProductExceptSelf pes = new ProductExceptSelf();
		int[] nums = {3};
//		int[] nums = {1,2,3,4};
		for (int i : pes.productExceptSelf(nums)) {
			System.out.println(i);
		}
	}
}
