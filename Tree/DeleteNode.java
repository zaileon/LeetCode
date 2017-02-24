import java.util.Arrays;

public class DeleteNode {

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) return null;
		if (root.val == key) {
			if (root.left != null) root = leftRotate(root);
			else if (root.right != null) root = rightRotate(root);
			else return null;
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else {
			root.left = deleteNode(root.left, key);
		}
		return root;
	}
	
	private TreeNode leftRotate(TreeNode root) {
		TreeNode left = root.left, node = left;
		while (node.right != null) node = node.right;
		node.right = root.right;
		return left;
	}
	
	private TreeNode rightRotate(TreeNode root) {
		TreeNode right = root.right, node = right;
		while (node.left != null) node = node.left;
		node.left = root.left;
		return right;
	}
	
	public static void main(String[] args) {
		DeleteNode dn = new DeleteNode();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(0));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(5,3,6,2,4,null,7));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(4,2,6,1,3,5,7));
		TreeNode node = dn.deleteNode(root, 0);
		TreeUtils.printTree(node);
	}

}
