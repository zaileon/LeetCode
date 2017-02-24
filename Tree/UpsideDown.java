import java.util.Arrays;

public class UpsideDown {
	
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null || root.left == null) return root;
		TreeNode newRoot = upsideDownBinaryTree(root.left);
		root.left.left = root.right;
		root.left.right = root;
		root.left = root.right = null;
		return newRoot;
	}
	
	public static void main(String[] args) {
		UpsideDown ud = new UpsideDown();
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,3));
		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,3,4,5));
		TreeUtils.printTree(ud.upsideDownBinaryTree(root));
	}
}
