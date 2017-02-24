import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FactorCombinations {

	public List<List<Integer>> getFactors(int n) {
		return helper(n, 2);
	}
	
	private List<List<Integer>> helper(int n, int factor) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = factor; i * i <= n; i++) {
			if (n % i == 0) { 
				result.add(new LinkedList<Integer>(Arrays.asList(i, n / i)));
				List<List<Integer>> pre = helper(n / i, i);
				for (List<Integer> list : pre) {
					list.add(0, i);
					result.add(list);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		FactorCombinations fc = new FactorCombinations();
		for (List<Integer> list : fc.getFactors(Integer.MAX_VALUE)) {
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}
}
