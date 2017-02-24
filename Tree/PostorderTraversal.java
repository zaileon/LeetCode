import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

//	public List<Integer> postorderTraversal(TreeNode root) {
//		List<Integer> result = new ArrayList<>();
//		if (root == null) return result;
//		Stack<TreeNode> stack = new Stack<>();
//		TreeNode prev = null, node;
//		stack.push(root);
//		while (!stack.isEmpty()) {
//			node = stack.peek();
//			boolean nochild = node.left == null && node.right == null;
//			boolean childrenvisited = prev != null && (prev == node.left || prev == node.right);
//			if (nochild || childrenvisited) {
//				node = stack.pop();
//				result.add(node.val);
//				prev = node;
//			} else {
//				if (node.right != null) stack.push(node.right);
//				if (node.left != null) stack.push(node.left);
//			}
//		}
//		return result;
//	}
	
	// the reverse of preorder, then reverse the result
//	public List<Integer> postorderTraversal(TreeNode root) {
//		List<Integer> result = new ArrayList<>();
//		if (root == null) return result;
//		Stack<TreeNode> stack = new Stack<>();
//		stack.push(root);
//		while (!stack.isEmpty()) {
//			TreeNode node = stack.pop();
//			result.add(node.val);
//			if (node.left != null) stack.push(node.left);
//			if (node.right != null) stack.push(node.right);
//		}
//		Collections.reverse(result);
//		return result;
//	}
	
	// another implementation as above
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				result.add(root.val);
				root = root.right;
			} else {
				root = stack.pop().left;
			}
		}
		Collections.reverse(result);
		return result;
	}
	
	public static void main(String[] args) {
		PostorderTraversal pt = new PostorderTraversal();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(4,2,6,1,3,5,7));
		for (int i : pt.postorderTraversal(root)) {
			System.out.println(i);
		}
	}
}
