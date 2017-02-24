import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		backtrack(result, new boolean[nums.length], nums, new ArrayList<>());
		return result;
	}
	
	private void backtrack(List<List<Integer>> result, boolean[] visited, int[] nums, List<Integer> perm) {
		if (perm.size() == visited.length) {
			result.add(new ArrayList<Integer>(perm));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])) continue; 
			visited[i] = true;
			perm.add(nums[i]);
			backtrack(result, visited, nums, perm);
			perm.remove(perm.size() - 1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		PermutationsII p2 = new PermutationsII();
		int[] nums = {1,1,2};
		for (List<Integer> perm : p2.permuteUnique(nums)) {
			for (int n : perm) {
				System.out.print(n);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

}
