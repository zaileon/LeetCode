import java.util.Arrays;

public class UnivalueSubtrees {
	
	public int countUnivalSubtrees(TreeNode root) {
		int[] count = new int[1];
		helper(root, count);
		return count[0];
	}
	
	private boolean helper(TreeNode root, int[] count) {
		if (root == null) return true;
		boolean left = helper(root.left, count);
		boolean right = helper(root.right, count);
		if (left && right) {
			if (root.left != null && root.left.val != root.val) return false;
			if (root.right != null && root.right.val != root.val) return false;
			count[0]++;
			return true;
		}
		return false;
	}

//	public int countUnivalSubtrees(TreeNode root) {
//		if (root == null) return 0;
//		return helper(root).count;
//	}
//	
//	private TreeNodeStats helper(TreeNode root) {
//		int sum = 0;
//		boolean flag = true;
//		if (root.left != null) {
//			TreeNodeStats s = helper(root.left);
//			sum += s.count;
//			flag = flag && s.flag && (root.val == root.left.val);
//		}
//		if (root.right != null) {
//			TreeNodeStats s = helper(root.right);
//			sum += s.count;
//			flag = flag && s.flag && (root.val == root.right.val);
//		}
//		return new TreeNodeStats(sum + (flag ? 1 : 0), flag);
//	}
	
	public static void main(String[] args) {
		UnivalueSubtrees us = new UnivalueSubtrees();
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(5,1,5,5,5,null,5));
		TreeNode root = TreeUtils.buildTree(Arrays.asList(5,5,5,5,1,null,5));
		System.out.println(us.countUnivalSubtrees(root));
	}
	
	class TreeNodeStats {
		int count = 0;
		boolean flag = true;
		public TreeNodeStats(int c, boolean f) { this.count = c; this.flag = f; }
	}
}
