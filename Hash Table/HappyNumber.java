public class HappyNumber {
	
	// Use Floyd Cycle detection, fastest on LC
	public boolean isHappy(int n) {
		int x = n, y = n;
        while (x > 1) {
            x = calc(x);
            if (x == 1) return true;
            y = calc(calc(y));
            if (y == 1) return true;
            if (x == y) return false;
        }
        return true;
	}
	
	// Use Hashset to keep visited numbers. If insertion fails, we are in a cycle
//	public boolean isHappy(int n) {
//		Set<Integer> visited = new HashSet<>();
//         while (n != 1) {
//             if (!visited.add(n)) return false;
//             n = calc(n);
//         }
//         return true;
//	}
	
	private int calc(int n) {
        int sum = 0, last;
        while (n > 0) {
            last = n % 10;
            sum += last * last;
            n /= 10;
        }
        return sum;
    }
}
