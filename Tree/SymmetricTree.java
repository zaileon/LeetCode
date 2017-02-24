import java.util.Arrays;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return isMirror(root.left, root.right);
	}
	
	private boolean isMirror(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
	}
	
	public static void main(String[] args) {
		SymmetricTree st = new SymmetricTree();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,3,3,null,2,null));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,2,null,3,null,3));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,2,3,4,4,3));
		System.out.println(st.isSymmetric(root));
	}
}
