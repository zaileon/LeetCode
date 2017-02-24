import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreePaths {
	
//	public List<String> binaryTreePaths(TreeNode root) {
//		List<String> paths = new ArrayList<>();
//		if (root == null) return paths;
//		if (root.left == null && root.right == null) return Arrays.asList(String.valueOf(root.val));
//		List<String> left = binaryTreePaths(root.left);
//		List<String> right = binaryTreePaths(root.right);
//		for (String p : left) paths.add(root.val + "->" + p);
//		for (String p : right) paths.add(root.val + "->" + p);
//		return paths;
//	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		helper(root, new StringBuilder(), paths);
		return paths;
	}
	
	private void helper(TreeNode node, StringBuilder sb, List<String> result) {
		if (node == null) return;
		int len = sb.length();
		if (node.left == null && node.right == null) {
			sb.append(node.val);
			result.add(new String(sb));
		} else {
			sb.append(node.val).append("->");
			helper(node.left, sb, result);
			helper(node.right, sb, result);
		}
		sb.setLength(len);
	}

	public static void main(String[] args) {
		TreePaths tp = new TreePaths();
		TreeNode root = null;
//		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,3,null,5));
		for (String p : tp.binaryTreePaths(root)) {
			System.out.println(p);
		}
	}

}
