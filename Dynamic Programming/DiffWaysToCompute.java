import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffWaysToCompute {

	Map<String, List<Integer>> map = new HashMap<>();
	
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				String p1 = input.substring(0, i);
				String p2 = input.substring(i + 1);
				List<Integer> left = map.getOrDefault(p1, diffWaysToCompute(p1));
				List<Integer> right = map.getOrDefault(p2, diffWaysToCompute(p2));
				for (int l : left) {
					for (int r : right) {
						switch (c) {
							case '+': result.add(l + r); break;
							case '-': result.add(l - r); break;
							case '*': result.add(l * r); break;
						}
					}
				}
			}
		}
		if (result.size() == 0) result.add(Integer.valueOf(input));
		map.put(input, result);
		return result;
	}
	
	public static void main(String[] args) {
		DiffWaysToCompute dwtc = new DiffWaysToCompute();
		String input = "2-1-1";
//		String input = "2*3-4*5";
		for (int i : dwtc.diffWaysToCompute(input)) {
			System.out.println(i);
		}
	}
}
