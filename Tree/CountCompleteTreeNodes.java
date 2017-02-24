import java.util.Arrays;

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		int h = height(root);
		if (height(root.right) == h - 1) { // The last element is in the right subtree. Left subtree plus root: 2**h
			return (1 << h) + countNodes(root.right);
		} else { // The last element is in the left subtree. Right subtree plus root: 2**(h-1)
			return (1 << h - 1) + countNodes(root.left);
		}
	}
	
	private int height(TreeNode root) {
		if (root == null) return 0;
		return 1 + height(root.left);
	}
	
	public static void main(String[] args) {
		CountCompleteTreeNodes cctn = new CountCompleteTreeNodes();
//		TreeNode root = TreeUtils.buildTree(Arrays.asList());
		TreeNode root = TreeUtils.buildTree(Arrays.asList(1));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,3,4,5,6,7));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,3,4,5,6,7,8,9));
		System.out.println(cctn.countNodes(root));
	}
}
