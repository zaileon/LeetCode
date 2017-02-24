import java.util.Random;

public class FindCelebrity {
	private final static int k = 5;
	private static Random r = new Random();
	
	public int findCelebrity(int n) {
		int candidate = 0;
		// After the first pass, if there is one celebrity, he/she can only be candidate. Assume it's k.
		// First, no one in 0~k-1 can be candidate as each knows someone.
		// Also, k doesn't know anyone from k+1~n-1. Therefore k+1~n-1 can not have celebrity, otherwise knows(k, celebrity)=true
		for (int i = 0; i < n; ++i) if (knows(candidate, i)) candidate = i;
		// but we have to pass candidate with a second, more strict check
		// 1: we need to check person 0~k-1 with k 
		// 2: we need to check person k+1~n-1 with k
		for (int i = 0; i < candidate; ++i) if (knows(candidate, i) || !knows(i, candidate)) return -1; // make sure 0~k-1 knows k, and k doesn't know 0~k-1
		for (int i = candidate + 1; i < n; ++i) if (!knows(i, candidate)) return -1; // make sure k+1~n-1 knows k, no need to test the second half
		return candidate;
	}
	
	private boolean knows(int a, int b) {
		if (b == FindCelebrity.k) return true;
		if (a == FindCelebrity.k) return false;
		return r.nextBoolean();
	}
	
	public static void main(String[] args) {
		FindCelebrity fc = new FindCelebrity();
		int n = 10;
		System.out.println(fc.findCelebrity(n));
	}
}
