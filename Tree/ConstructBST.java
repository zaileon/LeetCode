import java.util.HashMap;
import java.util.Map;

public class ConstructBST {
	
	// Use a HashMap to save inorder position will improve runtime significantly
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) return null;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
		return helper(preorder, 0, inorder, 0, inorder.length - 1, map);
	}
	
	// preEnd - preStart === inEnd - inStart
	private TreeNode helper(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
		if (inStart > inEnd) return null;
		
		int val = preorder[preStart];
		TreeNode root = new TreeNode(val);
		
		int idx = map.get(val);
		root.left = helper(preorder, preStart + 1, inorder, inStart, idx - 1, map);
		root.right = helper(preorder, preStart + idx - inStart + 1, inorder, idx + 1, inEnd, map);
		
		return root;
	}

	public static void main(String[] args) {
		ConstructBST cbst = new ConstructBST();
//		int[] preorder = {1,2}, inorder = {2,1};
		int[] preorder = {1}, inorder = {1};
//		int[] preorder = {4,2,1,3,6,5,7}, inorder = {1,2,3,4,5,6,7};
		TreeNode root = cbst.buildTree(preorder, inorder);
		System.out.println(root.val);
	}

}
