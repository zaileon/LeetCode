import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			result.add(root.val);
			if (root.right != null) stack.push(root.right);
			if (root.left != null) stack.push(root.left);
		}
		return result;
	}
	
	public static void main(String[] args) {
		PreorderTraversal pt = new PreorderTraversal();
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(4));
		TreeNode root = TreeUtils.buildTree(Arrays.asList(4,2,6,1,3,5,7));
		for (int i : pt.preorderTraversal(root)) {
			System.out.println(i);
		}
	}
}
