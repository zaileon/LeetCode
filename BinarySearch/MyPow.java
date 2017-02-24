
public class MyPow {
	public double myPow(double x, int n) {
		if (n == 0) return 1;
		if (n < 0) return 1 / myPow(x, ~n) / x;
		return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}
	
	public static void main(String[] args) {
		MyPow mp = new MyPow();
//		System.out.println(mp.myPow(3, 3));
//		System.out.println(mp.myPow(3, -3));
//		System.out.println(mp.myPow(3, 0));
//		System.out.println(mp.myPow(-3, -2));
		System.out.println(mp.myPow(1, Integer.MIN_VALUE));
	}
}
