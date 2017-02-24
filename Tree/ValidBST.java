import java.util.Arrays;

public class ValidBST {
	
//	TreeNode prev = null;
//	public boolean isValidBST(TreeNode root) {
//		return isValidBSTUtil(root);
//	}
//	
//	private boolean isValidBSTUtil(TreeNode node) {
//		if (node == null) return true;
//		if(!isValidBSTUtil(node.left)) return false;
//		if (prev != null && node.val <= prev.val) return false;
//		prev = node;
//		return isValidBSTUtil(node.right);
//	}
	
	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	private boolean isValidBSTHelper(TreeNode root, long min, long max) {
		if (root == null) return true;
		if (root.val >= max || root.val <= min) return false;
		return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
	}
	
	public static void main(String[] args) {
		ValidBST vbst = new ValidBST();
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(2,1,3));
		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,1));
		System.out.println(vbst.isValidBST(root));
	}
}
