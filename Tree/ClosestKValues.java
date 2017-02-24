import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ClosestKValues {
	
	// initialize: O(logn), getNextSuccessor/getNextPredecessor: O(logn)
	// The total time complexity: O(klogn)
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> result = new ArrayList<>();
		
		Stack<TreeNode> s1 = new Stack<>();  // predecessors;
		Stack<TreeNode> s2 = new Stack<>();
		initializePredecessors(root, target, s1);
		initializeSuccessors(root, target, s2);
		// remove a possible duplicate
		if (!s1.isEmpty() && !s2.isEmpty() && s1.peek().val == s2.peek().val) getNextPredecessor(s1);
		
		while (k-- > 0) {
			if (s1.isEmpty()) result.add(getNextSuccessor(s2));
			else if (s2.isEmpty()) result.add(getNextPredecessor(s1));
			else {
				double pred_diff = Math.abs((double)s1.peek().val - target);
				double succ_diff = Math.abs((double)s2.peek().val - target);
				if (pred_diff < succ_diff) result.add(getNextPredecessor(s1));
				else result.add(getNextSuccessor(s2));
			}
		}
		return result;
	}

	private void initializePredecessors(TreeNode root, double target, Stack<TreeNode> s) {
		while (root != null) {
			if (root.val == target) { s.push(root); break; }
			else if (root.val < target) { s.push(root); root = root.right; }
			else root = root.left;
		}
	}
	
	private void initializeSuccessors(TreeNode root, double target, Stack<TreeNode> s) {
		while (root != null) {
			if (root.val == target) { s.push(root); break; }
			else if (root.val > target) { s.push(root); root = root.left; }
			else root = root.right;
		}
	}
	
	private int getNextPredecessor(Stack<TreeNode> s) {
		TreeNode curr = s.pop();
		int ret = curr.val;
		curr = curr.left;
		while (curr != null) { s.push(curr); curr = curr.right; }
		return ret;
	}
	
	private int getNextSuccessor(Stack<TreeNode> s) {
		TreeNode curr = s.pop();
		int ret = curr.val;
		curr = curr.right;
		while (curr != null) { s.push(curr); curr = curr.left; }
		return ret;
	}
	
	// time complexity: O(n + k)
//	public List<Integer> closestKValues(TreeNode root, double target, int k) {
//		List<Integer> result = new ArrayList<>();
//		
//		Stack<Integer> s1 = new Stack<>();  // predecessors
//		Stack<Integer> s2 = new Stack<>();  // successors
//		
//		inorder(root, target, false, s1);
//		inorder(root, target, true, s2);
//		
//		while (k-- > 0) {
//			if (s1.isEmpty()) {
//				result.add(s2.pop());
//			} else if (s2.isEmpty()) {
//				result.add(s1.pop());
//			} else {
//				result.add(target - s1.peek() < s2.peek() - target ? s1.pop() : s2.pop());
//			}
//		}
//		
//		return result;
//	}
//	
//	private void inorder(TreeNode node, double target, boolean reverse, Stack<Integer> s) {
//		if (node == null) return;
//		inorder(reverse ? node.right : node.left, target, reverse, s);
//		if ((!reverse && node.val > target) || (reverse && node.val <= target)) return;
//		s.push(node.val);
//		inorder(reverse ? node.left : node.right, target, reverse, s);
//	}
	
	public static void main(String[] args) {
		ClosestKValues ckv = new ClosestKValues();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(3,2,4,1));
		double target = 2.0; int k = 3;
		for (int i : ckv.closestKValues(root, target, k)) {
			System.out.println(i);
		}
	}
}
