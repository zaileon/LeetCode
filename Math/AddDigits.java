
public class AddDigits {
	
	// digit root
	// the position it holds wrt the largest multiple of 9 less than the number itself
	// always greater than 0, so the possible valus are 1 ~ 9
	public int addDigits(int num) {
        return num - (num - 1) / 9 * 9;
    }
}
