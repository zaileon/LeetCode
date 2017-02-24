import java.util.Arrays;

public class RestoreBST {
	
	@SuppressWarnings("null")
	public void restoreTree(TreeNode root) {
		TreeNode first = null, second = null, pre = null, last = null;
		while (root != null) {
			if (root.left == null) {
				if (last != null && last.val > root.val) {
					if (first == null) first = last;
					second = root;
				}
				last = root;
				root = root.right;
			} else {
				pre = root.left;
				while (pre.right != null && pre.right != root) pre = pre.right;
				if (pre.right == null) {
					pre.right = root;
					root = root.left;
				} else {
					pre.right = null;
					if (last != null && last.val > root.val) {
						if (first == null) first = last;
						second = root;
					}
					last = root;
					root = root.right;
				}
			}
		}
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	public static void main(String[] args) {
		RestoreBST rbst = new RestoreBST();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(2,null,1));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(4,2,6,1,7,5,3));
		rbst.restoreTree(root);
	}

}
