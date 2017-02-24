import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

	public List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<>();
		if (num.length() == 0) return result;
		char[] path = new char[num.length() * 2 - 1];
		long n = 0;
		for (int i = 0; i < num.length(); i++) {
			n = n * 10 + num.charAt(i) - '0';
			path[i] = num.charAt(i);
			backtrack(result, path, i + 1, num, i + 1, target, 0, n);
			if (num.charAt(0) == '0') break; 
		}
		return result;
	}
	
	private void backtrack(List<String> result, char[] path, int len, String num, int start, int target, long prev, long curr) {
		if (start == num.length()) {
			if (prev + curr == target) result.add(new String(path, 0, len));
			return;
		}
		long n = 0;
		int j = len + 1;
		for (int i = start; i < num.length(); i++) {
			n = n * 10 + num.charAt(i) - '0';
			path[j++] = num.charAt(i);
			path[len] = '+';
			backtrack(result, path, j, num, i + 1, target, prev + curr, n);
			path[len] = '-';
			backtrack(result, path, j, num, i + 1, target, prev + curr, -n);
			path[len] = '*';
			backtrack(result, path, j, num, i + 1, target, prev, curr * n);
			if (num.charAt(start) == '0') break;
		}
	}
	
	public static void main(String[] args) {
		ExpressionAddOperators eao = new ExpressionAddOperators();
		String num = "000"; int target = 0;
//		String num = "232"; int target = 8;
//		String num = "123"; int target = 6;
		for (String ex : eao.addOperators(num, target)) {
			System.out.println(ex);
		}
	}
}
