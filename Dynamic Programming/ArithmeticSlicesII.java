import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesII {

	public int numberOfArithmeticSlices(int[] A) {
		Map<Integer, Integer>[] map = new Map[A.length];
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			map[i] = new HashMap<>();
			for (int j = 0; j < i; j++) {
				long diff = (long)A[i] - A[j];
				if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) continue;
				int d = (int)diff;
				int c1 = map[i].getOrDefault(d, 0); // for cases such as: [3,6,6,9]
				int c2 = map[j].getOrDefault(d, 0);
				res += c2;
				map[i].put(d, c1 + c2 + 1);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		ArithmeticSlicesII as = new ArithmeticSlicesII();
		int[] A = {0,2000000000,-294967296};
//		int[] A = {2,4,6,8,10};
		System.out.println(as.numberOfArithmeticSlices(A));
	}
}
