import java.util.Arrays;

public class PathSumIII {

	public int pathSum(TreeNode root, int sum) {
		if (root == null) return 0;
        return pathSum(root, sum, false);
    }
	
	private int pathSum(TreeNode root, int sum, boolean inPath) {
		int total = root.val == sum ? 1 : 0;
		if (root.left != null) {
			total += pathSum(root.left, sum - root.val, true);
			if (!inPath) total += pathSum(root.left, sum, false);
		}
		if (root.right != null) {
			total += pathSum(root.right, sum - root.val, true);
			if (!inPath) total += pathSum(root.right, sum, false);
		}
		return total;
	}
	
	public static void main(String[] args) {
		PathSumIII ps = new PathSumIII();
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(10,5,-3,3,2,null,11,3,-2,null,1)); int sum = 8;
		TreeNode root = null; int sum = 1;
		System.out.println(ps.pathSum(root, sum));
	}
}
