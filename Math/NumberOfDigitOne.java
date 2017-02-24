
public class NumberOfDigitOne {
	
	// starting from back to front for 3141592
	// when m = 100, a = 31415, b = 92,
	// the last digit of a is 5 (>=2), we get 3142 streaks of 1, each is 100 (for example 3141100~3141199, contribute 100 of 1s on hundredth digit)
	// when m = 100, a = 3141, b = 592
	// we get only 314 streaks of 1, each is 1000, plus b + 1 (000~592) of 1s
	public int countDigitOne(int n) {
		int count = 0;
	    for (long m = 1; m <= n; m *= 10) {
	    	int a = (int)(n/m), b = (int)(n%m);
	    	count += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
	    }
	    return count;
	}

	public static void main(String[] args) {
		NumberOfDigitOne ones = new NumberOfDigitOne();
		System.out.println(ones.countDigitOne(123));
	}

}
