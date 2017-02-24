import java.util.Arrays;
import java.util.List;

public class CountSmallerNumbersAfter {
	
	// Some small bug related to duplicate (I think)
//	public List<Integer> countSmaller(int[] nums) {
//		int len = nums.length;
//		ArrayList<Integer> list = new ArrayList<>();
//		List<Integer> result = new ArrayList<>(len);
//		for (int i = len - 1; i >= 0 ; i--) {
//			int idx = Collections.binarySearch(list, nums[i]);
//			if (idx < 0) idx = ~idx;
//			list.add(idx, nums[i]);
//			result.add(idx);
//		}
//		Collections.reverse(result);
//		return result;
//	}
	
	public List<Integer> countSmaller(int[] nums) {
		Integer[] count = new Integer[nums.length];
		if (nums.length == 0) return Arrays.asList(count);
		Node root = new Node(nums[nums.length - 1]);
		for (int i = nums.length - 1; i >= 0; i--) {
			count[i] = insert(root, nums[i]);
		}
		return Arrays.asList(count);
	}
	
	private int insert(Node node, int num) {
		int sum = 0;
		while (node.val != num) {
			if (node.val > num) {
				node.leftSum++;
				if (node.left == null) node.left = new Node(num);
				node = node.left;
			} else {
				sum += node.leftSum + (num > node.val ? 1 : 0);
				if (node.right == null) node.right = new Node(num);
				node = node.right;
			}
		}
		node.dup++;
		return sum + node.leftSum;
	}

	public static void main(String[] args) {
		CountSmallerNumbersAfter csna = new CountSmallerNumbersAfter();
		int[] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
		for (int i : csna.countSmaller(nums)) {
			System.out.println(i);
		}
	}
	
	class Node {
		int val, leftSum = 0, dup = 0;
		Node left, right;
		public Node(int val) {this.val = val;}
	}

}
