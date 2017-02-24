import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class ZigzagLevelOrder {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
		Deque<TreeNode> queue = new ArrayDeque<>();
		boolean even = false;
		TreeNode node;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int len = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < len; i++) {
				node = queue.poll();
				list.add(node.val);
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
			if (even) Collections.reverse(list);
			result.add(list);
			even = !even;
		}
		return result;
    }
	
	
//	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//		List<List<Integer>> result = new ArrayList<>();
//		travel(result, root, 0);
//		return result;
//	}
//	
//	private void travel(List<List<Integer>> result, TreeNode node, int level) {
//		if (node == null) return;
//		if (result.size() <= level) {
//			List<Integer> newLevel = new LinkedList<>();
//			result.add(newLevel);
//		}
//		List<Integer> collection = result.get(level);
//		if (level % 2 == 0) collection.add(node.val);
//		else collection.add(0, node.val);
//		travel(result, node.left, level + 1);
//		travel(result, node.right, level + 1);
//	}

	public static void main(String[] args) {
		ZigzagLevelOrder zlo = new ZigzagLevelOrder();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(0,2,4,1,null,3,-1,5,1,null,6,null,8));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(3,9,20,null,null,15,7));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,3,4,null,null,5));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(3));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(3,9,20,null,null,15,7));
		for (List<Integer> list : zlo.zigzagLevelOrder(root)) {
			for (int num : list) {
				System.out.print(num + " ");
			}
			System.out.println("");
		}
	}

}
