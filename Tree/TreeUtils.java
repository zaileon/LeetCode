import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class TreeUtils {

	public static TreeNode buildTree(List<Integer> values) {
		Deque<TreeNode> queue = new ArrayDeque<>();
		TreeNode root = new TreeNode(values.get(0));
		queue.add(root);
		for (int i = 1; i < values.size(); i++) {
			TreeNode parent = queue.removeFirst();
			if (values.get(i) != null) {
				TreeNode left = new TreeNode(values.get(i));
				parent.left = left;
				queue.addLast(left);
			}
			i++;
			if (i < values.size() && values.get(i) != null) {
				TreeNode right = new TreeNode(values.get(i));
				parent.right = right;
				queue.addLast(right);
			}
		}
		return root;
	}
	
	public static void printTree(TreeNode root) {
		if (root == null) return;
		printTree(root.left);
		System.out.println(root.val);
		printTree(root.right);
	}
}
