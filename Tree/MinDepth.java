import java.util.Arrays;

public class MinDepth {
	
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
	}
	
	public static void main(String[] args) {
		MinDepth md = new MinDepth();
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,null,2));
		TreeNode root = TreeUtils.buildTree(Arrays.asList(3,9,20,null,null,15,7));
		System.out.println(md.minDepth(root));
	}
}
