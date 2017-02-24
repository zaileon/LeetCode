import java.util.Arrays;

public class LongestConsecutivePath {
	public int longestConsecutive(TreeNode root) {
		if (root == null) return 0;
		return dfs(root, 0, root.val + 1);
	}
	
	private int dfs(TreeNode root, int count, int target) {
		if (root == null) return count;
		count = (root.val == target) ? (count + 1) : 1;
		int left  = dfs(root.left, count, root.val + 1);
		int right = dfs(root.right, count, root.val + 1);
		return Math.max(Math.max(left, right), count);
	}
	
	public static void main(String[] args) {
		LongestConsecutivePath lcp = new LongestConsecutivePath();
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,null,3,2,2,null,null,null,3));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(2,null,3,2,null,1,null));
		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,null,3,2,4,null,null,null,5));
		System.out.println(lcp.longestConsecutive(root));
	}
	
}
