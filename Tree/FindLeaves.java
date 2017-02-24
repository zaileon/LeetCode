import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLeaves {

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		List<List<Integer>> left = findLeaves(root.left);
		List<List<Integer>> right = findLeaves(root.right);
		for (int i = 0; i < Math.max(left.size(), right.size()); i++) {
			List<Integer> level = new ArrayList<>();
			if (i < left.size()) level.addAll(left.get(i));
			if (i < right.size()) level.addAll(right.get(i));
			result.add(level);
		}
		result.add(Arrays.asList(root.val));
		return result;
	}
	
	public static void main(String[] args) {
		FindLeaves fl = new FindLeaves();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,3,4,5));
		for (List<Integer> list : fl.findLeaves(root)) {
			for (int n : list) {
				System.out.print(n + " ");
			}
			System.out.println("");
		}
	}
}
