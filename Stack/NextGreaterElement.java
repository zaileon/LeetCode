import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for (int num : nums) {
			while (!stack.isEmpty() && stack.peek() < num) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}
		int[] result = new int[findNums.length];
		for (int i = 0; i < findNums.length; i++) {
			result[i] = map.containsKey(findNums[i]) ? map.get(findNums[i]) : -1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		NextGreaterElement nge = new NextGreaterElement();
		int[] findNums = {2,4}, nums = {1,2,3,4};
//		int[] findNums = {4,1,2}, nums = {1,3,4,2};
		int[] res = nge.nextGreaterElement(findNums, nums);
		for (int i : res) System.out.println(i);
	}
}
