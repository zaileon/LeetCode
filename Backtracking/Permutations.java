import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		backtrack(result, visited, nums, new ArrayList<>());
		return result;
	}
	
	private void backtrack(List<List<Integer>> result, boolean[] visited, int[] nums, List<Integer> res) {
		if (res.size() == nums.length) {
			result.add(new ArrayList<>(res));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				res.add(nums[i]);
				backtrack(result, visited, nums, res);
				visited[i] = false;
				res.remove(res.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Permutations p = new Permutations();
		int[] nums = {1,2,3};
		for (List<Integer> perm : p.permute(nums)) {
			for (int i : perm) {
				System.out.print(i);
				System.out.print(" ");				
			}
			System.out.println();
		}
	}

}
