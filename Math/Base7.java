
public class Base7 {
	
	public String convertToBase7(int num) {
		StringBuilder sb = new StringBuilder();
		boolean neg = num < 0;
		long n = Math.abs((long)num);
		while (n >= 7) {
			sb.append(n % 7);
			n /= 7;
		}
		sb.append(n);
		if (neg) sb.append("-");
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		Base7 b = new Base7();
		System.out.println(b.convertToBase7(100)); // "202"
		System.out.println(b.convertToBase7(-7)); // "-10"
		System.out.println(b.convertToBase7(0)); // "0"
		System.out.println(b.convertToBase7(Integer.MAX_VALUE)); // "0"
		System.out.println(b.convertToBase7(Integer.MIN_VALUE)); // "0"
	}

}
