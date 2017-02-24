import java.util.Arrays;

public class SumRootToLeaf {
	
	public int sumNumbers(TreeNode root) {
		if (root == null) return 0;
		return helper(root, 0);
	}
	
	private int helper(TreeNode root, int preSum) {
		int sum = preSum * 10 + root.val;
		if (root.left == null && root.right == null) return sum;
		int total = 0;
		if (root.left != null) total += helper(root.left, sum);
		if (root.right != null) total += helper(root.right, sum);
		return total;
	}
	

	public static void main(String[] args) {
		SumRootToLeaf srtl = new SumRootToLeaf();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,3,4,null,5,6,null,null,null,null,7));
		System.out.println(srtl.sumNumbers(root));
	}

}
