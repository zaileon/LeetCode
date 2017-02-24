import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModeBST {
	
	List<Integer> result = new ArrayList<>();
	Integer last = null;
	int count = 0, max = 0;
	public int[] findMode(TreeNode root) {
		if (root == null) return new int[0];
		inorder(root);
		int[] ret = new int[result.size()];
		int i = 0;
		for (int n : result) ret[i++] = n;
		return ret;
	}
	
	private void inorder(TreeNode root) {
		if (root == null) return;
		inorder(root.left);
		if (last == null || root.val == last) {
			count++;
		} else {
			count = 1;
		}
		if (count > max) {
			result.clear();
			result.add(root.val);
			max = count;
		} else if (count == max) {
			result.add(root.val);
		}
		last = root.val;
		inorder(root.right);
	}

	public static void main(String[] args) {
		ModeBST mode = new ModeBST();
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(1, null,2));
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(Integer.MAX_VALUE));
		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,null,2,2));
		for (int n : mode.findMode(root)) {
			System.out.println(n);
		}
	}

}
