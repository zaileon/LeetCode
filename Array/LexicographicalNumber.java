import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumber {

	public List<Integer> lexicalOrder(int n) {
		List<Integer> result = new ArrayList<>(n);
		result.add(1);
		for (int i = 1, prev = 1; i < n; i++) {
			if (prev * 10 <= n) 
				prev *= 10;
			else {
				while (prev % 10 == 9 || prev == n) prev /= 10;
				prev++;
			}
			result.add(prev);
		}
		return result;
	}
	
	public static void main(String[] args) {
		LexicographicalNumber ln = new LexicographicalNumber();
		for (int i : ln.lexicalOrder(23)) {
			System.out.println(i);
		}
	}
}
