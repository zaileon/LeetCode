import java.util.ArrayList;
import java.util.List;

public class UniqueBSTsII {

	public List<TreeNode> generateTrees(int n) {
		return generateTreesHelper(1, n);
    }
    
    private List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
        	result.add(null);
        	return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTreesHelper(start, i-1);
            List<TreeNode> rights = generateTreesHelper(i+1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		UniqueBSTsII ubst = new UniqueBSTsII();
		for (TreeNode node : ubst.generateTrees(3)) {
			System.out.println(node.val);
		}
	}

}