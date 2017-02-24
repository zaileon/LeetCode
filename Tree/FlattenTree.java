import java.util.Arrays;

public class FlattenTree {
	
	private TreeNode prev = null;
	public void flatten(TreeNode root) {
		if (root == null) return;
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}
	
	public static void main(String[] args) {
		FlattenTree ft = new FlattenTree();
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,null,3));
		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,5,3,4,6));
		ft.flatten(root);
		while (root != null) {
			System.out.println(root.val);
			root = root.right;
		}
	}
}
