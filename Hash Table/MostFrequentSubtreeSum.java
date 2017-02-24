import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
	
	public int[] findFrequentTreeSum(TreeNode root) {
		Map<Integer, Integer> counts = new HashMap<>();
		countTreeSum(root, counts);
		List<Integer> result = new ArrayList<>();
		int max = 0;
		for (int sum : counts.keySet()) {
			if (counts.get(sum) == max) 
				result.add(sum);
			else if (counts.get(sum) > max) {
				max = counts.get(sum);
				result.clear(); 
				result.add(sum);
			}
		}
		int[] res = new int[result.size()];
		for (int i = 0; i < result.size(); i++) res[i] = result.get(i);
		return res;
	}
	
	private int countTreeSum(TreeNode root, Map<Integer, Integer> counts) {
		if (root == null) return 0;
		int left = countTreeSum(root.left, counts);
		int right = countTreeSum(root.right, counts);
		int sum = left + right + root.val;
		counts.compute(sum, (k, v) -> v == null ? 1 : v + 1);
		return sum;
	}

	public static void main(String[] args) {
		MostFrequentSubtreeSum mfss = new MostFrequentSubtreeSum();
		TreeNode root = TreeUtils.buildTree(Arrays.asList(5,2,-5));
		int[] res = mfss.findFrequentTreeSum(root);
		System.out.println(res.length);
		for (int n : res) System.out.println(n);
	}

}
