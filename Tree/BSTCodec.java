import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BSTCodec {

	
	public String serialize(TreeNode root) {
		if (root == null) return "";
		StringBuilder sb = new StringBuilder();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			sb.append(root.val).append(",");
			if (root.right != null) stack.push(root.right);
			if (root.left != null) stack.push(root.left);
		}
		return sb.toString();
	}
	
	public TreeNode deserialize(String data) {
		List<Integer> values = new ArrayList<>();
		int n = 0;
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == ',') {
				values.add(n);
				n = 0;
			} else
				n = n * 10 + data.charAt(i) - '0';
		}
		return deserializeHelper(values, 0, values.size());
	}
	
	private TreeNode deserializeHelper(List<Integer> values, int i, int j) {
		if (i == j) return null; 
		int value = values.get(i);
		int k = i + 1;
		for (; k < j; k++) {
			if (values.get(k) > value) break;
		}
		TreeNode node = new TreeNode(value);
		node.left = deserializeHelper(values, i + 1, k);
		node.right = deserializeHelper(values, k, j);
		return node;
	}
	
	public static void main(String[] args) {
		BSTCodec codec = new BSTCodec();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(4,2,5,null,3,null,6));
		String data = codec.serialize(root);
		System.out.println(data);
//		TreeNode node = codec.deserialize(data);
		TreeNode node = codec.deserialize("");
		TreeUtils.printTree(node);
	}
}
