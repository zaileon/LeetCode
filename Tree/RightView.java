import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class RightView {
	
//	public List<Integer> rightSideView(TreeNode root) {
//		List<Integer> ret = new ArrayList<>();
//		if (root == null) return ret;
//		Deque<TreeNode> queue = new ArrayDeque<>();
//		queue.offer(root);
//		while (!queue.isEmpty()) {
//			int len = queue.size();
//			for (int i = 0; i < len; i++) {
//				TreeNode node = queue.pop();
//				if (i == len - 1) ret.add(node.val);
//				if (node.left != null) queue.offer(node.left);
//				if (node.right != null) queue.offer(node.right);
//			}
//		}
//		return ret;
//	}
	
	// DFS
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		dfs(root, ret, 0);
		return ret;
	}
	
	private void dfs(TreeNode node, List<Integer> ret, int currDepth) {
		if (node == null) return;
		if (currDepth == ret.size()) ret.add(node.val);
		dfs(node.right, ret, currDepth + 1);
		dfs(node.left, ret, currDepth + 1);
	}

	public static void main(String[] args) {
		RightView rv = new RightView();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,3,null,5,null,4,null,6));
		for (int i : rv.rightSideView(root)) {
			System.out.println(i);
		}
	}

}
