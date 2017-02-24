import java.util.Arrays;

public class LargestBSTSubtree {

	// use neg sign to indicate the current root is not in the largest BST
	public int largestBSTSubtree(TreeNode root) {
		Result result = BSTTree(root);
		return Math.abs(result.size);
	}
	
	private Result BSTTree(TreeNode root) {
		if (root == null) return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		Result left = BSTTree(root.left);
		Result right = BSTTree(root.right);
		if (left.size == -1 || right.size == -1 || root.val <= left.max || root.val >= right.min) {
			return new Result(Math.max(Math.abs(left.size), Math.abs(right.size)) * -1, 0, 0);
		}
		return new Result(left.size + right.size + 1, Math.min(left.min, root.val), Math.max(right.max, root.val));
	}
	
	public static void main(String[] args) {
		LargestBSTSubtree lbsts = new LargestBSTSubtree();
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(4,2,7,2,3,5,null,2,null,null,null,null,null,1));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE)); // bug! should return 1
		TreeNode root = TreeUtils.buildTree(Arrays.asList(0,Integer.MIN_VALUE,Integer.MAX_VALUE)); // bug! should return 3
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(10,5,15,1,8,null,7));
		System.out.println(lbsts.largestBSTSubtree(root));
	}

	class Result {
		int size;
		int min, max;
		Result(int sz, int min, int max) { this.size = sz; this.min = min; this.max = max; }
	}
}
