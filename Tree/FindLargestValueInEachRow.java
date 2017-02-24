import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLargestValueInEachRow {
	
	public List<Integer> largestValues(TreeNode root) {
		if (root == null) return new ArrayList<Integer>();
		List<Integer> res = new ArrayList<>();
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int max = Integer.MIN_VALUE, sz = queue.size();
			for (int i = 0; i < sz; i++) {
				TreeNode node = queue.poll();
				max = Math.max(max, node.val);
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
			res.add(max);
		}
		return res;
	}

	public static void main(String[] args) {
		FindLargestValueInEachRow flvr = new FindLargestValueInEachRow();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,3,2,5,3,null,9));
		for (int n : flvr.largestValues(root)) {
			System.out.println(n);
		}
	}

}
