import java.util.Arrays;
import java.util.Stack;

public class KthSmallestInBST {
	
//	public int kthSmallest(TreeNode root, int k) {
//		Stack<TreeNode> stack = new Stack<TreeNode>();
//		while (!stack.isEmpty() || root != null) {
//			while (root != null) {
//				stack.push(root);
//				root = root.left;
//			}
//			root = stack.pop();
//			--k;
//			if (k == 0) return root.val;
//			root = root.right;
//		}
//		return -1;
//	}
	
	public int kthSmallest(TreeNode root, int k) {
		TreeNodeWithRank node = buildTreeWithRank(root);
		return helper(node, k);
	}
	
	private int helper(TreeNodeWithRank node, int k) {
		int leftRank = node.left == null ? 0 : node.left.rank;
		if (k <= leftRank) return helper(node.left, k);
		if (k == leftRank + 1) return node.val;
		return helper(node.right, k - leftRank - 1);
	}
	
	private TreeNodeWithRank buildTreeWithRank(TreeNode root) {
		if (root == null) return null;
		TreeNodeWithRank left = buildTreeWithRank(root.left);
		TreeNodeWithRank right = buildTreeWithRank(root.right);
		int leftRank = left == null ? 0 : left.rank;
		int rightRank = right == null ? 0 : right.rank;
		TreeNodeWithRank newRoot = new TreeNodeWithRank(root.val, leftRank + rightRank + 1, left, right);
		return newRoot;
	}

	public static void main(String[] args) {
		KthSmallestInBST ksbst = new KthSmallestInBST();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(4,2,6,1,3,5,7));
		System.out.println(ksbst.kthSmallest(root, 3));
	}

}

class TreeNodeWithRank {
	int val, rank;
	TreeNodeWithRank left, right;
	public TreeNodeWithRank(int x, int r, TreeNodeWithRank left, TreeNodeWithRank right) { this.val = x; this.rank = r; this.left = left; this.right = right; }
}