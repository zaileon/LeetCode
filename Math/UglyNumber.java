
public class UglyNumber {
	public boolean isUgly(int num) {
		if (num < 1) return false;
		while (num % 2 == 0) num >>= 1;
		while (num % 3 == 0) num /= 3;
		while (num % 5 == 0) num /= 5;
		return num == 1;
	}
	
	public static void main(String[] args) {
		UglyNumber un = new UglyNumber();
		int num = -12;
		System.out.println(un.isUgly(num));
	}
}
