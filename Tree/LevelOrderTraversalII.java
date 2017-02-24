import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversalII {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
		if (root == null) return result;
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				TreeNode n = queue.removeFirst();
				level.add(n.val);
				if (n.left != null) queue.add(n.left);
				if (n.right != null) queue.add(n.right);
			}
			result.add(0, level);
		}
		return result;
	}
	
	public static void main(String[] args) {
		LevelOrderTraversalII lot = new LevelOrderTraversalII();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
		for (List<Integer> list : lot.levelOrder(root)) {
			for (int i : list) {
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
