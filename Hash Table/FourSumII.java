import java.util.HashMap;
import java.util.Map;

public class FourSumII {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = A[i] + B[j];
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}
		int res = 0;
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				res += map.getOrDefault(-(C[i] + D[j]), 0);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		FourSumII foursum = new FourSumII();
		int[] A = {1,2}, B = {-2,-1}, C = {-1,2}, D = {0,2};
		System.out.println(foursum.fourSumCount(A, B, C, D));
	}
}
