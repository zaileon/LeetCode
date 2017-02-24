
public class NthDigit {
	public int findNthDigit(int n) {
		int len = 1;
		for (long cnt = 9; n > cnt * len; len++) {
			n -= cnt * len;
			cnt *= 10;
		}
		n--;
		int number = (int) Math.pow(10, len - 1) + n / len;
		String s = Integer.toString(number);
		return s.charAt(n % len) - '0';
	}
	
	public static void main(String[] args) {
		NthDigit nd = new NthDigit();
		System.out.println(nd.findNthDigit(250)); // 1
		System.out.println(nd.findNthDigit(11)); // 0
		System.out.println(nd.findNthDigit(12)); // 1
		System.out.println(nd.findNthDigit(15)); // 2
		System.out.println(nd.findNthDigit(1000000000)); // 1
	}
}
