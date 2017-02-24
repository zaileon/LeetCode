
public class ConstructBinaryTree {
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length != postorder.length || inorder.length == 0) return null;
		return helper(inorder, postorder, 0, inorder.length - 1, 0);
	}
	
	private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart) {
		if (inStart > inEnd) return null;
		int i = inStart, val = postorder[postStart + inEnd - inStart];
		while (inorder[i] != val) i++; 
		TreeNode root = new TreeNode(val);
		root.left = helper(inorder, postorder, inStart, i - 1, postStart);
		root.right = helper(inorder, postorder, i + 1, inEnd, postStart + i - inStart);
		return root;
	}
	
	public static void main(String[] args) {
		ConstructBinaryTree construct = new ConstructBinaryTree();
		int[] inorder = {2,4,1,6,3}, postorder = {4,2,6,3,1};
		TreeNode root = construct.buildTree(inorder, postorder);
		TreeUtils.printTree(root);
	}
}
