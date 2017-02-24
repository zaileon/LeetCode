import java.util.Arrays;

public class MaximumPathSum {
	
	int maxPathSum;
	
	public int maxPathSum(TreeNode root) {
		maxPathSum = Integer.MIN_VALUE;
		maxPathDown(root);
		return maxPathSum;
	}
	
	private int maxPathDown(TreeNode root) {
		if (root == null) return 0;
		int left = Math.max(0, maxPathDown(root.left)); // if left max is negative, don't pick it
		int right = Math.max(0, maxPathDown(root.right)); // the same
		maxPathSum = Math.max(maxPathSum, left + root.val + right);// closed path passing through self
		return Math.max(left, right) + root.val; // open path including self and upper level node(s)
	}
	
	public static void main(String[] args) {
		MaximumPathSum mps = new MaximumPathSum();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(-8,-2,-1,-4,-5,-3));
		System.out.println(mps.maxPathSum(root));
	}
}
