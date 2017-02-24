import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	
	public List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();
		if (n < 0) return result;
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				result.add("FizzBuzz");
			} else if (i % 3 == 0) {
				result.add("Fizz");
			} else if (i % 5 == 0) {
				result.add("Buzz");
			} else {
				result.add(String.valueOf(i));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		FizzBuzz fb = new FizzBuzz();
		for (String num : fb.fizzBuzz(16)) {
			System.out.println(num);
		}
	}
}
