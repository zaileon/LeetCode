import java.util.Arrays;

public class BalancedBinaryTree {
	
	public boolean isBalanced(TreeNode root) {
		return dfs(root) != -1;
	}
	
	private int dfs(TreeNode root) {
		if (root == null) return 0;
		int left = dfs(root.left);
		int right = dfs(root.right);
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(3,null,20,15,7));
		System.out.println(bbt.isBalanced(root));
	}
}
