import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

//	public List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> res = new ArrayList<>();
//		Stack<TreeNode> stack = new Stack<>();
//		while (!stack.isEmpty() || root != null) {
//			while (root != null) {
//				stack.push(root);
//				root = root.left;
//			} 
//			root = stack.pop();
//			res.add(root.val);
//			root = root.right;
//		}
// 		return res;
//	}
	
	// Morris traversal
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		TreeNode pre, curr = root;
		while (curr != null) {
			if (curr.left == null) {
				res.add(curr.val);
				curr = curr.right;
			} else {
				pre = curr.left;
				while (pre.right != null && pre.right != curr) pre = pre.right;
				if (pre.right == null) { // find the immediate precursor, set its right to root
					pre.right = curr;
					curr = curr.left;
				} else {				// restore the right child of precursor and print out curr
					pre.right = null;
					res.add(curr.val);
					curr = curr.right;
				}
			}
		}
 		return res;
	}
	
	public static void main(String[] args) {
		InorderTraversal traversal = new InorderTraversal();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(1, null, 2, 3));
		for (int i : traversal.inorderTraversal(root)) {
			System.out.println(i);
		}
	}

}
