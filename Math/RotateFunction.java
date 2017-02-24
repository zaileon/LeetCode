
public class RotateFunction {
	
	public int maxRotateFunction(int[] A) {
		int max = 0, n = A.length, sum = 0;
		for (int i = 0; i < n; i++) {
			max += i * A[i];
			sum += A[i];
		}
		for (int i = 1, f = max; i < n; i++) {
			f = f + sum - n * A[n - i];
			if (f > max) max = f;
		}
		return max;
	}
	
	public static void main(String[] args) {
		RotateFunction rf = new RotateFunction();
		int[] A = {4,3,2,6};
		System.out.println(rf.maxRotateFunction(A));
	}
}
