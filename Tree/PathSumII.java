import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathSumII {
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<Integer>(), root, sum);
		return result;
	}
	
	private void backtrack(List<List<Integer>> result, List<Integer> path, TreeNode node, int sum) {
		if (node == null) return;
		path.add(node.val);
		if (node.left == null && node.right == null && node.val == sum) {
			result.add(new ArrayList<Integer>(path));
		} else {
			backtrack(result, path, node.left, sum - node.val);
			backtrack(result, path, node.right, sum - node.val);
		}
		path.remove(path.size() - 1);
	}
	
	public static void main(String[] args) {
		PathSumII ps = new PathSumII();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,5,1));
		for (List<Integer> l : ps.pathSum(root, 22)) {
			for (int i : l) System.out.print(i + " ");
			System.out.println("");
		}
	}
}
