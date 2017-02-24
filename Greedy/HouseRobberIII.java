import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
	
//	public int rob(TreeNode root) {
//		Map<TreeNode, Integer> map = new HashMap<>();
//		return helper(root, map);
//	}
//	
//	private int helper(TreeNode root, Map<TreeNode, Integer> map) {
//		if (root == null) return 0;
//		if (map.containsKey(root)) return map.get(root);
//		int total = root.val, left = 0, right = 0;
//		if (root.left != null) {
//			total += helper(root.left.left, map) + helper(root.left.right, map);
//			left = helper(root.left, map);
//		}
//		if (root.right != null) {
//			total += helper(root.right.left, map) + helper(root.right.right, map);
//			right = helper(root.right, map);
//		}
//		int max = Math.max(total, left + right);
//		map.put(root, max);
//		return max;
//	}
	
	// Greedy
	// separate the return value into two:
	// don't rob root, pick the larger ones from left and right
	// rob root, add the first elements (not rob) from left and right
	public int rob(TreeNode root) {
		int[] sum = robSub(root);
		return Math.max(sum[0], sum[1]);
	}
	
	private int[] robSub(TreeNode root) {
		if (root == null) return new int[] { 0, 0 };
		int[] left = robSub(root.left);
		int[] right = robSub(root.right);
		int[] sum = new int[2];
		sum[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		sum[1] = root.val + left[0] + right[0];
		return sum;
	}

	public static void main(String[] args) {
		HouseRobberIII hr = new HouseRobberIII();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(3,4,5,1,3,null,1));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(3,2,3,null,3,null,1));
		System.out.println(hr.rob(root));
	}

}
