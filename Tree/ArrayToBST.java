
public class ArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) return null;
		return helper(nums, 0, nums.length - 1);
	}
	
	private TreeNode helper(int[] nums, int start, int end) {
		if (start > end) return null;
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, start, mid - 1);
		root.right = helper(nums, mid + 1, end);
		return root;
	}
	
	public static void main(String[] args) {
		ArrayToBST atbst = new ArrayToBST();
		int[] nums = {1,2,3,4,5,6,7};
		TreeUtils.printTree(atbst.sortedArrayToBST(nums));
	}
}
