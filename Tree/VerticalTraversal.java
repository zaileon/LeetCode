import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalTraversal {
	
	// within each list, higher node is before lower node, so level order BFS is required
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();
		
		q.add(root);
		cols.add(0);
		
		int min = 0, max = 0;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int col = cols.poll();
			
			map.putIfAbsent(col, new ArrayList<Integer>());
			map.get(col).add(node.val);
			
			if (node.left != null) {
				q.offer(node.left);
				cols.offer(col - 1);
				min = Math.min(min, col - 1);
			}
			
			if (node.right != null) {
				q.offer(node.right);
				cols.offer(col + 1);
				max = Math.max(max, col + 1);
			}
		}
		
		for (int i = min; i <= max; i++) {
			result.add(map.get(i));
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		VerticalTraversal vt = new VerticalTraversal();
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(3,9,20,null,null,15,7));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(3,9,8,4,0,1,7));
		TreeNode root = TreeUtils.buildTree(Arrays.asList(3,9,8,4,0,1,7,null,null,null,2,5));
		for (List<Integer> l : vt.verticalOrder(root)) {
			for (int i : l) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}
}
