import java.util.Arrays;

public class ClosestValue {

	public int closestValue(TreeNode root, double target) {
		int num = root.val;
		TreeNode child = target < num ? root.left : root.right;
		if (child == null) return num;
		int b = closestValue(child, target);
		return Math.abs(num - target) < Math.abs(b - target) ? num : b;
	}
	
	// slower?
//	public int closestValue(TreeNode root, double target) {
//		int ret = root.val;
//		while (root != null) {
//			if (Math.abs(root.val - target) < Math.abs(ret - target)) ret = root.val;
//			root = root.val > target ? root.left : root.right;
//		}
//		return ret;
//	}
	
	public static void main(String[] args) {
		ClosestValue cv = new ClosestValue();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(0));
		double target = 2147483648.0;
		System.out.println(cv.closestValue(root, target));
	}
}
