import java.util.Arrays;

public class InvertBinaryTree {
	
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return root;
		TreeNode newLeft  = invertTree(root.right);
		TreeNode newRight = invertTree(root.left);
		root.left = newLeft;
		root.right = newRight;
		return root;
	}

	public static void main(String[] args) {
		InvertBinaryTree ibt = new InvertBinaryTree();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(4,2,7,1,3,6,9));
		root = ibt.invertTree(root);
		
	}

}
