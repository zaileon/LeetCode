import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(1, new ArrayList<Integer>(), result, k, n);
		return result;
	}
	
	public void backtrack(int start, List<Integer> list, List<List<Integer>> result, int k, int n) {
		if (k < 0) return;
		if (n == 0 && k == 0) {
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i <= 9 && i <= n; i++) {
			list.add(i);
			backtrack(i + 1, list, result, k - 1, n - i);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		CombinationSumIII cs = new CombinationSumIII();
		int k = 3, n = 9;
//		int k = 3, n = 7;
		for (List<Integer> list : cs.combinationSum3(k, n)) {
			for (int i : list) {
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
