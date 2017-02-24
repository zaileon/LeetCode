import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BSTIterator {

	private TreeNode root;
	private Deque<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
		this.root = root;
		this.stack = new ArrayDeque<TreeNode>();
	}
	
	public boolean hasNext() {
		return !stack.isEmpty() || root != null;
	}
	
	public int next() {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		root = stack.pop();
		int val = root.val;
		root = root.right;
		return val;
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeUtils.buildTree(Arrays.asList(4,2,6,1,3,5,7));
		BSTIterator bi = new BSTIterator(root);
		while (bi.hasNext()) {
			System.out.println(bi.next());
		}
	}
	
}
