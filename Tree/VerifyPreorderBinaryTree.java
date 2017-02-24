public class VerifyPreorderBinaryTree {
	
	// diff = outdegree - indegree, for every node, we reduce diff by 1 as it provides an indegree
	// if the node is not "#", we increase outdegree by 2
	// if the serialization is correct, diff will never be negative, and zero at the end
	public boolean isValidSerialization(String preorder) {
		String[] nodes = preorder.split(",");
		int diff = 1;
		for (String node : nodes) {
			if (--diff < 0) return false;
			if (!node.equals("#")) diff += 2;
		}
		return diff == 0;
	}

	public static void main(String[] args) {
		VerifyPreorderBinaryTree v = new VerifyPreorderBinaryTree();
//		String preorder = "1,#,#,#,#";
//		String preorder = "#";
//		String preorder = "#,#";
//		String preorder = "9,#,#,1";
//		String preorder = "1,#";
//		String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		String preorder = "9,3,4,#,#,1,#,#,#,2,#,6,#,#";
		
//		String inorder = "#,4,#,3,#,1,#,9,#,2,#,6,#";   // set diff = 2, and check diff == 1 at the end
//		
		System.out.println(v.isValidSerialization(preorder));
	}

}
