import java.util.ArrayDeque;
import java.util.Arrays;

public class FindBottomLeftTreeValue {

	public int findBottomLeftValue(TreeNode root) {
		if (root == null) return -1;
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int sz = queue.size();
			TreeNode head = queue.peek();
			for (int i = 0; i < sz; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
			if (queue.isEmpty()) return head.val;
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		FindBottomLeftTreeValue fbltv = new FindBottomLeftTreeValue();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,3,4,null,5,6,null,null,7));
		System.out.println(fbltv.findBottomLeftValue(root));
	}
}
