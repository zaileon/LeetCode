import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<>();
		dfs(0, candidates, target, result, new ArrayList<Integer>());
		return result;
	}
	
	public void dfs(int start, int[] candidates, int target, List<List<Integer>> result, List<Integer> list) {
		if (target == 0) {
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
			if (i > start && candidates[i] == candidates[i - 1]) continue;
			list.add(candidates[i]);
			dfs(i + 1, candidates, target - candidates[i], result, list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSumII cs = new CombinationSumII();
//		int[] candidates = {1,2,2,5}; int target = 5;
		int[] candidates = {1,2,2,2,5}; int target = 10;
//		int[] candidates = {10, 1, 2, 7, 6, 1, 5}; int target = 8;
		for (List<Integer> list : cs.combinationSum2(candidates, target)) {
			for (int i : list) {
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

}
