
public class DivideTwoIntegers {
	
	public int divide(int dividend, int divisor) {
		if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
		boolean neg = (dividend < 0 ) ^  (divisor < 0);
		long dvnd = Math.abs((long)dividend);
		long dvsr = Math.abs((long)divisor);
		int quotient = 0;
		while (dvnd >= dvsr) {
			int offset = 0;
			long partial = dvsr;
			while (dvnd >= partial << 1) {
				offset++;
				partial <<= 1;
			}
			dvnd -= partial;
			quotient += 1 << offset;
		}
		if (neg) quotient = -quotient;
		return quotient;
	}
	
	public static void main(String[] args) {
		DivideTwoIntegers dti = new DivideTwoIntegers();
		System.out.println(dti.divide(Integer.MIN_VALUE, 1));
	}
}
