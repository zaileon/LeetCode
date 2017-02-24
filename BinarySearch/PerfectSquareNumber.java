
public class PerfectSquareNumber {
	
	public boolean isPerfectSquare(int num) {
		long r = num;
		while (r * r > num) {
			r = (r + num / r) / 2;
		}
		return r * r == num;
	}

	public static void main(String[] args) {
		PerfectSquareNumber psn = new PerfectSquareNumber();
		System.out.println(psn.isPerfectSquare(16));
		System.out.println(psn.isPerfectSquare(14));
		System.out.println(psn.isPerfectSquare(Integer.MAX_VALUE));
		System.out.println(psn.isPerfectSquare(1));
	}

}
