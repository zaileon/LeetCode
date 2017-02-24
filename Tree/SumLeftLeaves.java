import java.util.Arrays;

public class SumLeftLeaves {
	
	public int sumOfLeftLeaves(TreeNode root) {
		return helper(root, false);
	}
	
	private int helper(TreeNode root, boolean left) {
		if (root == null) return 0;
		if (root.left == null && root.right == null && left) return root.val; // only return left leaves value
		return helper(root.left, true) + helper(root.right, false);
	}

	public static void main(String[] args) {
		SumLeftLeaves sll = new SumLeftLeaves();
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(1));
		TreeNode root = TreeUtils.buildTree(Arrays.asList(3,9,20,null,null,15,7));
		System.out.println(sll.sumOfLeftLeaves(root));
	}

}
