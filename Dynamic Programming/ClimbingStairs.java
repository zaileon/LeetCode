
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;
		int f1 = 1, f2 = 2, f = 0;
		for (int i = 2; i < n; i++) {
			f = f1 + f2;
			f1 = f2;
			f2 = f;
		}
		return f;
    }
}