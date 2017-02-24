import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
			list.add(candidates[i]);
			dfs(i, candidates, target - candidates[i], result, list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] candidates = {8,7,4,3}; int target = 11;
//		int[] candidates = {2,3,6,7}; int target = 7;
		for (List<Integer> list : cs.combinationSum(candidates, target)) {
			for (int i : list) {
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

}
