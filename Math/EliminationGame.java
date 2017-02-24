
public class EliminationGame {

//	public int lastRemaining(int n) {
//		boolean left = true;
//		int head = 1, step = 1, remaining = n;
//		while (remaining > 1) {
//			if (left || (remaining % 2 == 1)) {
//				head += step;
//			}
//			remaining >>= 1;
//			step <<= 1;
//			left = !left;
//		}
//		return head;
//	}
	
	// lastRemaining(n) + lastRemainingFromRight(n) = n + 1
	// lastRemaining(n/2) + lastRemainingFromRight(n/2) = n/2 + 1
	// after the first elimination from left, the rest elements are even numbers: 2 * (1,2,3,4,...,n/2)
	// lastRemainingFromRight(n/2) = (n/2+1-lastRemaining(n/2))
	public int lastRemaining(int n) {
		if (n == 1) return 1;
		return 2 * (1 + n / 2 - lastRemaining(n / 2));
	}
	
	public static void main(String[] args) {
		EliminationGame eg = new EliminationGame();
		System.out.println(eg.lastRemaining(9));
	}
}
