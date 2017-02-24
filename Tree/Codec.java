import java.util.Arrays;
import java.util.StringTokenizer;

public class Codec {

	public String serialize(TreeNode root) {
		if (root == null) return "";
		StringBuilder sb = new StringBuilder();
		serializeHelper(root, sb);
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
	
	private void serializeHelper(TreeNode root, StringBuilder sb) {
		if (root == null) { sb.append('#').append(','); return; }
		sb.append(root.val).append(',');
		serializeHelper(root.left, sb);
		serializeHelper(root.right, sb);
	}
	
	public TreeNode deserialize(String data) {
		StringTokenizer st = new StringTokenizer(data, ",");
		return deserializeHelper(st);
	}
	
	private TreeNode deserializeHelper(StringTokenizer st) {
		String s;
		if (!st.hasMoreTokens() || (s = st.nextToken()).equals("#")) return null;
		TreeNode node = new TreeNode(Integer.parseInt(s));
		node.left = deserializeHelper(st);
		node.right = deserializeHelper(st);
		return node;
	}
	
	public static void main(String[] args) {
		Codec c = new Codec();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(1,2,3,null,4,5));
		String data = c.serialize(root);
		TreeNode newRoot = c.deserialize(data);
	}
}
