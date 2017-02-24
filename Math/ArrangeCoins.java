
public class ArrangeCoins {
	public int arrangeCoins(int n) {
		return ((int)Math.sqrt(1 + 8.0 * n) - 1) / 2;
	}
	
	public static void main(String[] args) {
		ArrangeCoins ac = new ArrangeCoins();
		System.out.println(ac.arrangeCoins(1)); // 1
		System.out.println(ac.arrangeCoins(Integer.MAX_VALUE)); // 65535
	}
}
