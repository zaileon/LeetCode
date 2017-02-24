
public class TrailingZeroes {
	
	public int trailingZeroes(int n) {
		int cnt = 0;
		while (n >= 5) {
		    n /= 5;
		    cnt += n;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		TrailingZeroes tz = new TrailingZeroes();
		System.out.println(tz.trailingZeroes(11));
	}
}
