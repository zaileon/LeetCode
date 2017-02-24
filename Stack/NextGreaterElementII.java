import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

	public int[] nextGreaterElements(int[] nums) {
		int[] result = new int[nums.length];
		Arrays.fill(result, -1);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
				result[stack.pop()] = nums[i];
			}
			stack.push(i);
		}
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
				result[stack.pop()] = nums[i];
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		NextGreaterElementII ng = new NextGreaterElementII();
		int[] nums = {1,7,3,6,2,5};
		int[] res = ng.nextGreaterElements(nums);
		for (int i : res) System.out.println(i);
	}
}
