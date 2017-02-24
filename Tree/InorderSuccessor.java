import java.util.Arrays;

public class InorderSuccessor {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode succ = null;
		while (root != null) {
			if (p.val < root.val) {
				succ = root;
				root = root.left;
			} else
				root = root.right;
		}
		return succ;
	}
	
	// recursive
//	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//		if (root == null) return null;
//		if (p.val > root.val) 
//			return inorderSuccessor(root.right, p);
//		else {
//			TreeNode s = inorderSuccessor(root.left, p);
//			return s == null ? root : s;
//		}
//	}
	
	public static void main(String[] args) {
		InorderSuccessor is = new InorderSuccessor();
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(6,2,8,0,4,7,9,null,null,3,5));
		TreeNode root = TreeUtils.buildTree(Arrays.asList(4,2,6,1,3,5,7));
		System.out.println(is.inorderSuccessor(root, new TreeNode(3)).val);
	}

}
