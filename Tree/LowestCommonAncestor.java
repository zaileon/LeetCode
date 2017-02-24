
public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return left == null ? right : (right == null ? left : root);
	}
	
	public static void main(String[] args) {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t6 = new TreeNode(6);
		t1.left = t2; t1.right = t3;
		t2.right = t4;
		t3.left = t6;
		System.out.println(lca.lowestCommonAncestor(t1, t4, t3).val);
	}
}
